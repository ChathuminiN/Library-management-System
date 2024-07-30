package controller;

import java.io.IOException;


import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

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
    void btnBooksOnAction(ActionEvent event) throws IOException {
        System.out.println("Clicked on Books");
        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/Books.fxml"));
        this.root.getChildren().add(node);


    }

    @FXML
    void btnBorrowingsOnAction(ActionEvent event) throws IOException {
        System.out.println("Clicked on Borrowings");

        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/Borrowing.fxml"));
        this.root.getChildren().add(node);

    }

    @FXML
    void btnCatogoryOnAction(ActionEvent event) throws IOException {
        System.out.println("Clicked on Book Category");
        //////////////////////////////////////////////////////////////////////////////////////////////////
            // URL resource = this.getClass().getResource("/view/Category.fxml");
            // Parent root = FXMLLoader.load(resource);
            // Stage stage=new Stage();
            // stage.setScene(new Scene(root));
            // stage.show();
            // stage.setTitle("Book Categories");

            this.root.getChildren().clear();
            Parent node = FXMLLoader.load(this.getClass().getResource("/view/Category.fxml"));
            this.root.getChildren().add(node);
            
            //////////////////////////////////////////////////////////////////////////////////////////////////

    

    }

    @FXML
    void btnContactOnAction(ActionEvent event) throws IOException {
        System.out.println("Clicked on Contact us");
        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/ContactUs.fxml"));
        this.root.getChildren().add(node);

    }

    @FXML
    void btnMembersOnAction(ActionEvent event)throws IOException {
        System.out.println("Clicked on Members");

        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/Members.fxml"));
        this.root.getChildren().add(node);

    }

    @FXML
    void btnBorrowingDetailsOnAction(ActionEvent event) throws IOException {

        System.out.println("Clicked on Borrowing Details");
        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/BorrowingDetails.fxml"));
        this.root.getChildren().add(node);

    }

}
