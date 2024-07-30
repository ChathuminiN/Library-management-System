package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import dto.BorrowingDto;
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
import service.custom.BorrowingService;
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
    private TableColumn<BorrowingTM, String> colReturndate;

    @FXML
    private TableView<BorrowingTM> tblBorrowing;
    

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
            String borrDate=txtBDate.getText();
            String dueDate=txtDDate.getText();
            String rtnDate=txtRDate.getText();
            Double fine=Double.parseDouble(txtFine.getText());
            
            if (borrID != null && !borrID.isEmpty() && mid != null && !mid.isEmpty()&&bookId != null && !bookId.isEmpty()&& borrDate != null&& !borrDate.isEmpty()) {
                BorrowingDto borrowingDto = new BorrowingDto(borrID,mid,bookId,borrDate,dueDate,rtnDate,fine);
                String resp = borrowingService.save(borrowingDto);
    
                showAlert(AlertType.INFORMATION, "Status", resp);
                clearForm();
                loadTable();
            } else {
                showAlert(AlertType.WARNING, "Error", "Relevent field  must be Included");
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
            String borrID = txtBorrowingID.getText();            
            String resp = borrowingService.delete(borrID);
            
            if ("Success".equals(resp)) {
                System.out.println("Borrowing deleted successfully.");
                showAlert(AlertType.INFORMATION, "Status", "Borrowing deleted successfully.");
                
            } else {
                System.out.println("Failed to delete book: " + resp);
                showAlert(AlertType.ERROR, "Delete Failed", "Failed to delete : " + resp);
            }
    
            clearForm();
            loadTable();
        } catch (Exception e) {
            
            showAlert(AlertType.ERROR, "Error", "An error occurred while deleting : " + e.getMessage());
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
                    txtBDate.setText(dto.getBorrDate());
                    txtDDate.setText(dto.getDueDate());
                    txtRDate.setText(dto.getRtnDate());
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
            String borrMID=txtBorrowingID.getText();            
            BorrowingDto dto = borrowingService.getMID(borrMID);
     
                 if (dto != null) {                    
                    txtBorrowingID.setText(dto.getBorrID());
                    txtMemberID.setText(dto.getMid());
                    txtBookID.setText(dto.getBookId());
                    txtBDate.setText(dto.getBorrDate());
                    txtDDate.setText(dto.getDueDate());
                    txtRDate.setText(dto.getRtnDate());
                    txtFine.setText(dto.getFine().toString());
                     
 
                 } else {
                     showAlert(Alert.AlertType.WARNING, "Not Found", "Borowing not found.");
                 }
             
             
         } catch (Exception e) {
             
             showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while searching: " + e.getMessage());
         }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        System.out.println("update");
        update();

    }

    private void update() {
        try{
            String borrID=txtBorrowingID.getText();
            String mid=txtMemberID.getText();
            String bookId=txtBookID.getText();
            String borrDate=txtBDate.getText();
            String dueDate=txtDDate.getText();
            String rtnDate=txtRDate.getText();
            Double fine=Double.parseDouble(txtFine.getText());
            
            if (borrID != null && !borrID.isEmpty() && mid != null && !mid.isEmpty()&&bookId != null && !bookId.isEmpty()&& borrDate != null&& !borrDate.isEmpty()) {
                BorrowingDto borrowingDto = new BorrowingDto(borrID,mid,bookId,borrDate,dueDate,rtnDate,fine);
                String resp = borrowingService.update(borrowingDto);
                
    
                showAlert(AlertType.INFORMATION, "Status", resp);
                clearForm();
                loadTable();
            } else {
                showAlert(AlertType.WARNING, "Error", "Relevent field  must be Included");
            }
        } catch (Exception e) {
            
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Error while Updating " + e.getMessage());
        }
    }

    private void loadTable() {
        try {
            colBorrowingID.setCellValueFactory(new PropertyValueFactory<>("borrID"));
            colMemberID.setCellValueFactory(new PropertyValueFactory<>("mid"));
            colBookID.setCellValueFactory(new PropertyValueFactory<>("bookId"));
            colBorrowDate.setCellValueFactory(new PropertyValueFactory<>("borrDate"));
            colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
            colReturndate.setCellValueFactory(new PropertyValueFactory<>("rtnDate"));
            colFine.setCellValueFactory(new PropertyValueFactory<>("fine"));

            
        
            ArrayList<BorrowingDto> borrowingDtos = borrowingService.getAll();
            ObservableList<BorrowingTM> borrowingTMList = FXCollections.observableArrayList();
            for(BorrowingDto borr:borrowingDtos){            
                BorrowingTM borrowingTM = new BorrowingTM(
                            borr.getBorrID(),
                            borr.getMid(),
                            borr.getBookId(),
                            borr.getBorrDate(),
                            borr.getDueDate(),
                            borr.getRtnDate(),
                            borr.getFine());                            
                            
                borrowingTMList.add(borrowingTM);
            }
        System.out.println(borrowingTMList);
        ;
        tblBorrowing.setItems((ObservableList<BorrowingTM>) borrowingTMList);
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
        txtBorrowingID.setText("");
        txtMemberID .setText("");
        txtBookID.setText("");
        txtBDate .setText("");
        txtDDate.setText("");
        txtRDate.setText("");
        txtFine.setText("");
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
