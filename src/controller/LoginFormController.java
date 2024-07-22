package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;

// import com.jfoenix.controls.JFXButton;
// import com.jfoenix.controls.JFXRadioButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
// import javafx.scene.image.ImageView;
// import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class LoginFormController {
    @FXML
    private JFXButton btnForgetPassword;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private ImageView imgLogin;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblTitle;

    @FXML
    private JFXRadioButton rBtnRememberMe;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    private Label lblLms;


     // Predefined values for username and password
     private final String VALID_USERNAME = "admin";
     private final String VALID_PASSWORD = "password123";
   

    //permission for login to the system
    @FXML
    void btnLoginOnAction(ActionEvent event) {
        System.out.println("Logged");

        String enteredUsername = txtEmail.getText();
        String enteredPassword = txtPassword.getText();

        if (enteredUsername.equals(VALID_USERNAME) && enteredPassword.equals(VALID_PASSWORD)) {
            showAlert(AlertType.INFORMATION, "Login Successful", "Welcome, " + enteredUsername + "!");
        } else {
            showAlert(AlertType.ERROR, "Login Failed", "Invalid username or password.");
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
