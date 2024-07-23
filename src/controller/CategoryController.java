package controller;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CategoryController {
    @FXML
    private JFXButton btnCreate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colCatName;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private Label lblCatId;

    @FXML
    private Label lblCatName;

    @FXML
    private Label lblLms;

    @FXML
    private Label lblTitle;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<?> tblCategory;

    @FXML
    private TextField txtCatId;

    @FXML
    private TextField txtCatName;

}


