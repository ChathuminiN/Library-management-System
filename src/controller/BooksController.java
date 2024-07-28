package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class BooksController {

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colCatId;

    @FXML
    private TableColumn<?, ?> colCopiesAvail;

    @FXML
    private TableColumn<?, ?> colIsbn;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableColumn<?, ?> colYear;

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
    private TableView<?> tblBook;

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

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}

