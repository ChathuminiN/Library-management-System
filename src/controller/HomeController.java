package controller;

import java.io.IOException;
import java.net.URL;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


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
        URL resource = this.getClass().getResource("/view/Books.fxml");
            Parent root = FXMLLoader.load(resource);
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            stage.setTitle("Books");


    }

    @FXML
    void btnBorrowingsOnAction(ActionEvent event) throws IOException {
        System.out.println("Clicked on Borrowings");

        URL resource = this.getClass().getResource("/view/Borrowing.fxml");
            Parent root = FXMLLoader.load(resource);
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            stage.setTitle("Borrowing");

    }

    @FXML
    void btnCatogoryOnAction(ActionEvent event) throws IOException {
        System.out.println("Clicked on Book Category");
        
            URL resource = this.getClass().getResource("/view/Category.fxml");
            Parent root = FXMLLoader.load(resource);
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            stage.setTitle("Book Categories");

    }

    @FXML
    void btnContactOnAction(ActionEvent event) throws IOException {
        System.out.println("Clicked on Contact us");
        URL resource = this.getClass().getResource("/view/ContactUs.fxml");
        Parent root = FXMLLoader.load(resource);
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("ContactUs");;

    }

    @FXML
    void btnMembersOnAction(ActionEvent event)throws IOException {
        System.out.println("Clicked on Members");

        URL resource = this.getClass().getResource("/view/Members.fxml");
            Parent root = FXMLLoader.load(resource);
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            stage.setTitle("Members");

    }

    @FXML
    void btnBorrowingDetailsOnAction(ActionEvent event) throws IOException {

        System.out.println("Clicked on Borrowing Details");
        URL resource = this.getClass().getResource("/view/BorrowingDetails.fxml");
            Parent root = FXMLLoader.load(resource);
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            stage.setTitle("Borrowing Details");

    }

}
