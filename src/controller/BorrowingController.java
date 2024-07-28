package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class BorrowingController {

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
    ////////////////////////////////////////////

    @FXML
    private TableColumn<?, ?> colBookID;

    @FXML
    private TableColumn<?, ?> colBorrowDate;

    @FXML
    private TableColumn<?, ?> colBorrowingID;

    @FXML
    private TableColumn<?, ?> colDueDate;

    @FXML
    private TableColumn<?, ?> colFine;

    @FXML
    private TableColumn<?, ?> colMemberID;

    @FXML
    private TableColumn<?, ?> colReturndate;

    @FXML
    private TableView<?> tblBorrowing;
    ////////////////////////////////////////////

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

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchBIDOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchMIDOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
