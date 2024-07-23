package controller;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class HomeController {
    @FXML
    private JFXButton btnBooks;

    @FXML
    private JFXButton btnBorrowingDetails;

    @FXML
    private JFXButton btnBorrowings;

    @FXML
    private JFXButton btnCatogory;

    @FXML
    private JFXButton btnContact;

    @FXML
    private JFXButton btnMembers;

    @FXML
    private Label lblLms;

    @FXML
    private Label lblTitle;

    @FXML
    private AnchorPane root;

    @FXML
    void btnBooksOnAction(ActionEvent event) {
        System.out.println("Clicked on Books");

    }

    @FXML
    void btnBorrowingsOnAction(ActionEvent event) {
        System.out.println("Clicked on Borrowings");

    }

    @FXML
    void btnCatogoryOnAction(ActionEvent event) {
        System.out.println("Clicked on Book Category");

    }

    @FXML
    void btnContactOnAction(ActionEvent event) {
        System.out.println("Clicked on Contact us");

    }

    @FXML
    void btnMembersOnAction(ActionEvent event) {
        System.out.println("Clicked on Members");

    }

}
