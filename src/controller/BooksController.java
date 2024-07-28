package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import dto.BookDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import service.ServiceFactory;
import service.custom.BookService;
import tm.BookTM;

public class BooksController implements Initializable{

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnSearch;
    
    @FXML
    private JFXButton btnSearchClear;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<BookTM, String> colAuthor;////////////////////////

    @FXML
    private TableColumn<BookTM, String> colBookId;////////////////////////

    @FXML
    private TableColumn<BookTM, String> colCatId;////////////////////////

    @FXML
    private TableColumn<BookTM, String> colCopiesAvail;////////////////////////

    @FXML
    private TableColumn<BookTM, String> colIsbn;////////////////////////

    @FXML
    private TableColumn<BookTM, String> colTitle;////////////////////////

    @FXML
    private TableColumn<BookTM, String> colYear;////////////////////////

    @FXML
    private TableView<BookTM> tblBook;////////////////////////


    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblBookID;

    @FXML
    private Label lblBookTitle;

    @FXML
    private Label lblCatId;

    @FXML
    private Label lblCopiesAvail;

    @FXML
    private Label lblIsbn;

    @FXML
    private Label lblLms;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblyear;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookID;

    @FXML
    private TextField txtBookTitle;

    @FXML
    private TextField txtCatId;

    @FXML
    private TextField txtCopiesAvail1;

    @FXML
    private TextField txtIsbn;

    @FXML
    private TextField txtYear;

    ////////////////////////////////////////////////
     private BookService bookService = (BookService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOK);
    
    public BooksController() {
    }

    
    @FXML
     void btnSaveOnAction(ActionEvent event) {
         System.out.println("save");
         save();
 
     }
    private void save() {
        try {
            String bookID=txtBookID.getText();
            String title=txtBookTitle.getText();
            String author=txtAuthor.getText();
            String catId=txtCatId.getText();
            Integer copiesa=Integer.parseInt(txtCopiesAvail1.getText());
            Integer year=Integer.parseInt(txtYear.getText());
            String isbn=txtIsbn.getText();
            
            if (catId != null && !catId.isEmpty() && bookID != null && !bookID.isEmpty()&&author != null && !author.isEmpty()&& copiesa != null&& copiesa!=0) {
                BookDto bookDto = new BookDto(bookID, title, author, catId, year, isbn, copiesa);
                String resp = bookService.save(bookDto);
    
                showAlert(AlertType.INFORMATION, "Status", resp);
                clearForm();
                loadTable();
            } else {
                showAlert(AlertType.WARNING, "Error", "BookID,Title,Author,Category ID and Copies Available must be Included");
            }
        } catch (Exception e) {
            
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Error while saving " + e.getMessage());
        }
        
    }


    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        System.out.println("Delete");
        delete();

    }

    private void delete() {
        try {
            String bookID = txtBookID.getText();            
            String resp = bookService.delete(bookID);
            
            if ("Success".equals(resp)) {
                System.out.println("Book deleted successfully.");
                showAlert(AlertType.INFORMATION, "Status", "Book deleted successfully.");
                
            } else {
                System.out.println("Failed to delete book: " + resp);
                showAlert(AlertType.ERROR, "Delete Failed", "Failed to delete Book: " + resp);
            }
    
            clearForm();
            loadTable();
        } catch (Exception e) {
            
            showAlert(AlertType.ERROR, "Error", "An error occurred while deleting the book: " + e.getMessage());
        }
    }


    @FXML
    void btnSearchOnAction(ActionEvent event) {
        System.out.println("search");
        search();
        

    }
    @FXML
    void btnSearchClearOnAction(ActionEvent event) {
        clearForm();

    }


    private void search() {
        try {
            String BookID=txtBookID.getText();            
            BookDto dto = bookService.get(BookID);
    
                if (dto != null) {                    
                    txtBookTitle.setText(dto.getTitle());
                    txtAuthor.setText(dto.getAuthor());
                    txtCatId.setText(dto.getCatId());
                    txtIsbn.setText(dto.getIsbn());
                    txtYear.setText(Integer.toString(dto.getYear()));
                    txtCopiesAvail1.setText(Integer.toString(dto.getCopiesa()));

                } else {
                    showAlert(Alert.AlertType.WARNING, "Not Found", "Book not found.");
                }
            
            
        } catch (Exception e) {
            
            showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while searching for the Book: " + e.getMessage());
        }
    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        System.out.println("update");
        update();

    }

    private void update() {
        try {
            String bookID=txtBookID.getText();
            String title=txtBookTitle.getText();
            String author=txtAuthor.getText();
            String catId=txtCatId.getText();
            Integer copiesa=Integer.parseInt(txtCopiesAvail1.getText());
            Integer year=Integer.parseInt(txtYear.getText());
            String isbn=txtIsbn.getText();

            if (catId != null && !catId.isEmpty() && bookID != null && !bookID.isEmpty()&&author != null && !author.isEmpty()&& copiesa != null&& copiesa!=0) {
                BookDto bookDto = new BookDto(bookID, title, author, catId, year, isbn, copiesa);
                String resp = bookService.update(bookDto);
                showAlert(AlertType.INFORMATION, "Status", resp);
                clearForm();
                loadTable();
            }else{
                showAlert(AlertType.ERROR, "Error", "BookID,Title,Author,Category ID and Copies Available must be Included\nIf Difficult to find details,First You can search by Book ID");

            }       
                                   
        } catch (Exception e) {
            showAlert(AlertType.ERROR, "Error", "An error occurred while updating the category: " + e.getMessage());
           
        }
    }


    private void loadTable() {
    
        try {
            colBookId.setCellValueFactory(new PropertyValueFactory<>("bookID"));
            colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
            colCatId.setCellValueFactory(new PropertyValueFactory<>("catId"));
            colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
            colIsbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
            colCopiesAvail.setCellValueFactory(new PropertyValueFactory<>("copiesa"));
        
            ArrayList<BookDto> bookDtos = bookService.getAll();
            ObservableList<BookTM> bookTMList = FXCollections.observableArrayList();
            for(BookDto bk:bookDtos){            
                BookTM bookTM = new BookTM(
                            bk.getBookID(),
                            bk.getTitle(),
                            bk.getAuthor(),
                            bk.getCatId(),
                            bk.getYear(),
                            bk.getIsbn(),
                            bk.getCopiesa());
                bookTMList.add(bookTM);
            }
        System.out.println(bookTMList);
        tblBook.setItems((ObservableList<BookTM>) bookTMList);
        } catch (Exception e) {     
            System.out.println(e.getMessage());       
            showAlert(Alert.AlertType.ERROR, "Error", "Table Loading Error" + e.getMessage());
        }

        
    }


    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearForm() {
        txtBookID.setText("");
        txtBookTitle.setText("");
        txtAuthor.setText("");
        txtCatId.setText("");
        txtIsbn.setText("");
        txtYear.setText("");
        txtCopiesAvail1.setText("");

        
    }

   @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

