package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MembersController implements Initializable {

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnSearchID;

    @FXML
    private JFXButton btnSearchName;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnUpdate;
/////////////////////////////////////////////
    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colMID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colYeacolContact;

    @FXML
    private TableView<?> tblMembers;
//////////////////////////////////////////////

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblContact;

    @FXML
    private Label lblDOB;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblLms;

    @FXML
    private Label lblMemberID;

    @FXML
    private Label lblName;

    @FXML
    private Label lblTitle;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtDOB;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtMemberID;

    @FXML
    private TextField txtName;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        delete();

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        save();

    }

    @FXML
    void btnSearchIDOnAction(ActionEvent event) {
        searchID();

    }

    @FXML
    void btnSearchNameOnAction(ActionEvent event) {
        searchName();


    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearForm();

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        update();

    }
    private void loadTable() {
        // TODO Auto-generated method stub
        }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearForm() {
        txtMemberID.setText("");
        txtName.setText("");
        txtDOB.setText("");
        txtAddress.setText("");
        txtContact.setText("");
        txtEmail.setText("");
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
}
