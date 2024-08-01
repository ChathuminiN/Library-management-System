package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;



import com.jfoenix.controls.JFXButton;
import dto.BookDto;

import dto.BorrowingDto;
import dto.MemberDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import service.ServiceFactory;
import service.custom.BookService;
import service.custom.BorrowingService;
import service.custom.MemberService;

import service.custom.impl.BorrowingServiceImpl;


import tm.BorrowingTM;


public class BorrowingController implements Initializable{

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnSearchBID;

    @FXML
    private JFXButton btnSearchMID;

    @FXML
    private JFXButton btnUpdate;
     
    @FXML
    private JFXButton btnSearchBookName;
    

    @FXML
    private TableColumn<BorrowingTM, String> colBookID;

    @FXML
    private TableColumn<BorrowingTM, String> colBorrowDate;

    @FXML
    private TableColumn<BorrowingTM, String> colBorrowingID;

    @FXML
    private TableColumn<BorrowingTM, String> colDueDate;

    @FXML
    private TableColumn<BorrowingTM, String> colFine;

    @FXML
    private TableColumn<BorrowingTM, String> colMemberID;

   
    @FXML
    private TableColumn<BorrowingTM, CheckBox> colReturndate;

    @FXML
    private TableView<BorrowingTM> tblBorrowing;

    @FXML
    private Label lblBookTitle;

    @FXML
    private Label lblMemeberDetail;
    

    @FXML
    private Label lblBookID;

    @FXML
    private Label lblBorrowDate;

    @FXML
    private Label lblBorrowingID;

    @FXML
    private Label lblDuedate;

    @FXML
    private Label lblFinr;

    @FXML
    private Label lblLms;

    @FXML
    private Label lblMemberID;

    @FXML
    private Label lblReturndate;

    @FXML
    private Label lblTitle;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtBDate;

    @FXML
    private TextField txtBookID;

    @FXML
    private TextField txtBorrowingID;

    @FXML
    private TextField txtDDate;

    @FXML
    private TextField txtFine;

    @FXML
    private TextField txtMemberID;

    @FXML
    private TextField txtRDate;
    private  BorrowingService borrowingService = (BorrowingService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BORROWINGS); 
    private  BookService bookService = (BookService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOK);
    private  MemberService memberService = (MemberService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBER);
    
    @FXML
    void btnSearchBookNameOnAction(ActionEvent event) {
        searchBookName();

    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void searchBookName() {
        try {
            String bookID=txtBookID.getText();            
            BookDto dto = bookService.get(bookID);//calling method to get book name
     
                 if (dto != null) {                    
                    lblBookTitle.setText(dto.getTitle()+" | copies Available: "+dto.getCopiesa());
                     
                 } else {
                     showAlert(Alert.AlertType.WARNING, "Not Found", "Book not found.");
                 }
             
             
         } catch (Exception e) {
             
             showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while searching: " + e.getMessage());
         }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        System.out.println("Save");
        save();

    }

    private void save() {
        try {
            String borrID=txtBorrowingID.getText();
            String mid=txtMemberID.getText();
            String bookId=txtBookID.getText();
            LocalDate borrDate=LocalDate.now();
            LocalDate dueDate = borrDate.plusDays(14);
        
            Double fine=Double.parseDouble(txtFine.getText());
            fine=0.00;

            if(bookService.isBookAvailable(bookId)){

                if (borrID != null && !borrID.isEmpty() && mid != null && !mid.isEmpty()&&bookId != null && !bookId.isEmpty()&& borrDate != null) {
                    BorrowingDto borrowingDto = new BorrowingDto(borrID,mid,bookId,borrDate,dueDate,false,fine);
                    String resp = borrowingService.save(borrowingDto);                  
                           
                    showAlert(AlertType.INFORMATION, "Status", resp);
                    clearForm();
                    loadTable();
                } else {
                    showAlert(AlertType.WARNING, "Error", "Relevent field  must be Included");
                }

            }else{
                System.out.println("Book Not Available at the moment");
                showAlert(AlertType.WARNING, "Status", "Book Not Available at the moment");
            }

            
            
        } catch (Exception e) {
            
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Error while saving " + e.getMessage());
        }
    }

    
    
    
    @FXML
    void btnSearchBIDOnAction(ActionEvent event) {
        System.out.println("search borrwID");
        searchBID();

    }

    private void searchBID() {
        try {
           String borrID=txtBorrowingID.getText();            
           BorrowingDto dto = borrowingService.getBID(borrID);
    
                if (dto != null) {                    
                    txtBorrowingID.setText(dto.getBorrID());
                    txtMemberID.setText(dto.getMid());
                    txtBookID.setText(dto.getBookId());
                    txtBDate.setText(String.valueOf(dto.getBorrDate()));
                    txtDDate.setText(String.valueOf(dto.getDueDate()));    
                    txtFine.setText(dto.getFine().toString());

                                        

                } else {
                    showAlert(Alert.AlertType.WARNING, "Not Found", "Borowing not found.");
                }
            
            
        } catch (Exception e) {
            
            showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while searching: " + e.getMessage());
        };
    }

    @FXML
    void btnSearchMIDOnAction(ActionEvent event) {
        System.out.println("Search memID");
        searchMID();

    }

    private void searchMID() {
        try {
            String memID=txtMemberID.getText();            
            MemberDto dto = memberService.get(memID);//calling method to get memberDetail
     
                 if (dto != null) {                    
                    lblMemeberDetail.setText(dto.getMemberName()+"  |  "+ dto.getContact());
                     
                 } else {
                     showAlert(Alert.AlertType.WARNING, "Not Found", "Member not found.");
                 }
             
             
         } catch (Exception e) {
             
             showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while searching: " + e.getMessage());
         }
    }

    

    
    private void loadTable() {
        try {
            colBorrowingID.setCellValueFactory(new PropertyValueFactory<>("borrID"));
            colMemberID.setCellValueFactory(new PropertyValueFactory<>("mid"));
            colBookID.setCellValueFactory(new PropertyValueFactory<>("bookId"));
            colBorrowDate.setCellValueFactory(new PropertyValueFactory<>("borrDate"));
            colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
            colReturndate.setCellValueFactory(new PropertyValueFactory<>("isReturn"));
            colFine.setCellValueFactory(new PropertyValueFactory<>("fine"));

            ArrayList<BorrowingDto> borrowingDtos = borrowingService.getAll();
            ObservableList<BorrowingTM> borrowingTMList = FXCollections.observableArrayList();
            for(BorrowingDto borr:borrowingDtos){   
                  CheckBox checkBox = new CheckBox();
                  checkBox.setSelected(borr.isReturn());       
                BorrowingTM borrowingTM = new BorrowingTM(borr.getBorrID(),
                borr.getMid(),borr.getBookId(),borr.getBorrDate(),borr.getDueDate(),checkBox,borr.getFine());
                                               
                            
                borrowingTMList.add(borrowingTM);
                checkBoxOnAction(checkBox,borrowingDtos);   
            }
        System.out.println(borrowingTMList);
        ;
        tblBorrowing.setItems((ObservableList<BorrowingTM>) borrowingTMList);
        } catch (Exception e) {     
            System.out.println(e.getMessage());       
            showAlert(Alert.AlertType.ERROR, "Error", "Table Loading Error" + e.getMessage());
        }
    }


   private void checkBoxOnAction(CheckBox checkBox, List<BorrowingDto> borrowingList) {
    BorrowingService borrowingServiceImpl2 = new BorrowingServiceImpl();
    checkBox.setOnAction((e) -> {
        //BorrowingTM selectedItem = tblBorrowing.getSelectionModel().getSelectedItem();
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);


                Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure reservation Complete?",
                        yes, no).showAndWait();
                if (type.orElse(no) == yes) {
                    int focusedIndex = tblBorrowing.getSelectionModel().getSelectedIndex();
                    System.out.println("forcued INdex" + focusedIndex);
                    try {
                        boolean update = borrowingServiceImpl2.update((borrowingList.get(focusedIndex+1)).getBorrID(),borrowingList.get(focusedIndex+1).getBookId());
                        if(update){
                            checkBox.setSelected(true);
                        }
                        else{
                            checkBox.setSelected(false);
                        }
                    } catch (Exception e1) {
                        
                        e1.printStackTrace();
                        showAlert(Alert.AlertType.ERROR, "Error", "Error" + e1.getMessage());
                    }
                    

                }
                else{

                }

    });
        
        }




    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearForm() {
        txtBorrowingID.setText("");
        txtMemberID .setText("");
        txtBookID.setText("");
        txtBDate .setText("");
        txtDDate.setText("");
        txtRDate.setText("");
        txtFine.setText("");
        lblBookTitle.setText("");
        lblMemeberDetail.setText("");
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

