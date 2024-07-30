package controller;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import dto.BorrowingDetailDto;
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
import service.custom.BorrowingsDService;
import tm.BorrowingDTM;


public class BorrowingDetailController implements Initializable {

    @FXML
    private JFXButton btnSearchBID;

    @FXML
    private JFXButton btnSearchBookID;

    @FXML
    private TableColumn<BorrowingDTM, String> colBookID;

    @FXML
    private TableColumn<BorrowingDTM, String> colBorrowingID;

    @FXML
    private Label lblBookID;

    @FXML
    private Label lblBorrowingID;

    @FXML
    private Label lblLms;

    @FXML
    private Label lblTitle;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<BorrowingDTM> tblBorrowingDetails;

    @FXML
    private TextField txtBookID;

    @FXML
    private TextField txtBorrowingID;

    private  BorrowingsDService borrowingsDService = (BorrowingsDService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BORROWINGDETAILS); 


    

   
    
    @FXML
    void btnSearchBIDOnAction(ActionEvent event) {
        searchBID();
        clearForm();
        loadTable();

    }

    private void searchBID() {
        try {
            String borrID=txtBorrowingID.getText();            
            BorrowingDetailDto dto = borrowingsDService.getBorrID(borrID);
     
                 if (dto != null) {                    
                    txtBorrowingID.setText(dto.getBrrId());
                    txtBookID.setText(dto.getBookId());                     
 
                 } else {
                     showAlert(Alert.AlertType.WARNING, "Not Found", "Borowing not found.");
                 }
             
             
         } catch (Exception e) {
             showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while searching: " + e.getMessage());
         }
    }

   

    @FXML
    void btnSearchBookIDOnAction(ActionEvent event) {
        searchBookID();
        clearForm();
        loadTable();
        

    }

    private void searchBookID() {
        try {
            String bookID=txtBorrowingID.getText();            
            BorrowingDetailDto dto = borrowingsDService.getBID(bookID);
     
                 if (dto != null) {                    
                    txtBorrowingID.setText(dto.getBrrId());
                    txtBookID.setText(dto.getBookId());                     
 
                 } else {
                     showAlert(Alert.AlertType.WARNING, "Not Found", "Borowing not found.");
                 }
             
             
         } catch (Exception e) {
             showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while searching: " + e.getMessage());
         }
    }

    

    private void loadTable() {
        try {
            colBorrowingID.setCellValueFactory(new PropertyValueFactory<>("borrID"));
            colBookID.setCellValueFactory(new PropertyValueFactory<>("bookId"));
                     
        ArrayList<BorrowingDetailDto> borrowingDetailDtos = borrowingsDService.getAll();
            ObservableList<BorrowingDTM> borrowingDTMList = FXCollections.observableArrayList();
            for(BorrowingDetailDto borr:borrowingDetailDtos){            
                BorrowingDTM borrowingTM = new BorrowingDTM(
                            borr.getBrrId(),
                            borr.getBookId());                     
                            
                borrowingDTMList.add(borrowingTM);
            }
        System.out.println(borrowingDTMList);
        ;
        tblBorrowingDetails.setItems((ObservableList<BorrowingDTM>) borrowingDTMList);
        } catch (Exception e) {     
            System.out.println(e.getMessage());       
            showAlert(Alert.AlertType.ERROR, "Error", "Table Loading Error" + e.getMessage());
        }
    }

    private void clearForm() {
        txtBorrowingID.setText("");
        txtBookID.setText("");
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}


