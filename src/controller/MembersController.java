package controller;

import java.net.URL;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.ResourceBundle;
=======
import java.util.ResourceBundle;

>>>>>>> f977738b85816bdc630f829195bd91e74ef54928
import com.jfoenix.controls.JFXButton;
import dto.MemberDto;
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
import service.custom.MemberService;
import tm.MemberTM;

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

    @FXML
    private TableColumn<MemberTM, String> colAddress;

    @FXML
    private TableColumn<MemberTM, String> colDOB;

    @FXML
    private TableColumn<MemberTM, String> colEmail;

    @FXML
    private TableColumn<MemberTM, String> colMID;

    @FXML
    private TableColumn<MemberTM, String> colName;

    @FXML
    private TableColumn<MemberTM, String> colContact;

    @FXML
    private TableView<MemberTM> tblMembers;


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

<<<<<<< HEAD
    private MemberService memberService = (MemberService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBER);

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        System.out.println("save");
=======
    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        delete();

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
>>>>>>> f977738b85816bdc630f829195bd91e74ef54928
        save();

    }

    private void save() {
        try {
            String memberID=txtMemberID.getText();
            String memberName=txtName.getText();
            String dob=txtDOB.getText();
            String adrress=txtAddress.getText();
            String contact=txtContact.getText();
            String email=txtEmail.getText();
            
            if (memberID != null && !memberID.isEmpty() && memberName != null && !memberName.isEmpty()&&adrress != null && !adrress.isEmpty()&& contact != null&& !contact.isEmpty()) {
                MemberDto memberDto = new MemberDto(memberID, memberName, dob, adrress, contact, email);
                String resp = memberService.save(memberDto);
    
                showAlert(AlertType.INFORMATION, "Status", resp);
                clearForm();
                loadTable();
            } else {
                showAlert(AlertType.WARNING, "Error", "memberID,name,address&contact  must be Included");
            }
        } catch (Exception e) {
            
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Error while saving " + e.getMessage());
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        System.out.println("delete");
        delete();

    }

    private void delete() {
        try {
            String memID = txtMemberID.getText();            
            String resp = memberService.delete(memID);
            
            if ("Success".equals(resp)) {
                System.out.println("Member deleted successfully.");
                showAlert(AlertType.INFORMATION, "Status", "Member deleted successfully.");
                
            } else {
                System.out.println("Failed to delete book: " + resp);
                showAlert(AlertType.ERROR, "Delete Failed", "Failed to delete Member: " + resp);
            }
    
            clearForm();
            loadTable();
        } catch (Exception e) {
            
            showAlert(AlertType.ERROR, "Error", "An error occurred while deleting : " + e.getMessage());
        }
    }

    @FXML
    void btnSearchIDOnAction(ActionEvent event) {
        searchID();

    }

    private void searchID() {
        try {
            String memID=txtMemberID.getText();            
            MemberDto dto = memberService.get(memID);
    
                if (dto != null) {                    
                    txtName.setText(dto.getMemberName());
                    txtDOB.setText(dto.getDob());
                    txtAddress.setText(dto.getAdrress());
                    txtContact.setText(dto.getContact());
                    txtEmail.setText(dto.getEmail());
                    

                } else {
                    showAlert(Alert.AlertType.WARNING, "Not Found", "Member not found.");
                }
            
            
        } catch (Exception e) {
            
            showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while searching for the Member: " + e.getMessage());
        }
    }

    @FXML
    void btnSearchNameOnAction(ActionEvent event) {
        searchName();


    }

<<<<<<< HEAD
    private void searchName() {
        try {
            String memName=txtName.getText();            
            MemberDto dto = memberService.getN(memName);
    
                if (dto != null) {                    
                    txtMemberID.setText(dto.getMemberID());
                    txtDOB.setText(dto.getDob());
                    txtAddress.setText(dto.getAdrress());
                    txtContact.setText(dto.getContact());
                    txtEmail.setText(dto.getEmail());
                    

                } else {
                    showAlert(Alert.AlertType.WARNING, "Not Found", "Member not found.");
                }
            
            
        } catch (Exception e) {
            
            showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while searching for the Member: " + e.getMessage());
        }
    }

=======
>>>>>>> f977738b85816bdc630f829195bd91e74ef54928
    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearForm();

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        update();

    }
<<<<<<< HEAD
    private void update() {
        try{
            String memberID=txtMemberID.getText();
            String memberName=txtName.getText();
            String dob=txtDOB.getText();
            String adrress=txtAddress.getText();
            String contact=txtContact.getText();
            String email=txtEmail.getText();
            
            if (memberID != null && !memberID.isEmpty() && memberName != null && !memberName.isEmpty()&&adrress != null && !adrress.isEmpty()&& contact != null&& !contact.isEmpty()) {
                MemberDto memberDto = new MemberDto(memberID, memberName, dob, adrress, contact, email);
                String resp = memberService.update(memberDto);
    
                showAlert(AlertType.INFORMATION, "Status", resp);
                clearForm();
                loadTable();
            } else {
                showAlert(AlertType.WARNING, "Error", "memberID,name,address&contact  must be Included");
            }
        
        } catch (Exception e) {
            
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Error while uPDATING " + e.getMessage());
        }
        
    }
    

    private void loadTable() {
        try {
            colMID.setCellValueFactory(new PropertyValueFactory<>("memberID"));
            colName.setCellValueFactory(new PropertyValueFactory<>("memberName"));
            colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("adrress"));
            colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
            colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            
        
            ArrayList<MemberDto> memberDtos = memberService.getAll();
            ObservableList<MemberTM> memberTMList = FXCollections.observableArrayList();
            for(MemberDto mem:memberDtos){            
                MemberTM memberTM = new MemberTM(
                            mem.getMemberID(),
                            mem.getMemberName(),
                            mem.getDob(),
                            mem.getAdrress(),
                            mem.getContact(),
                            mem.getEmail());
                            
                memberTMList.add(memberTM);
            }
        System.out.println(memberTMList);
        ;
        tblMembers.setItems((ObservableList<MemberTM>) memberTMList);
        } catch (Exception e) {     
            System.out.println(e.getMessage());       
            showAlert(Alert.AlertType.ERROR, "Error", "Table Loading Error" + e.getMessage());
        }
=======
    private void loadTable() {
        // TODO Auto-generated method stub
>>>>>>> f977738b85816bdc630f829195bd91e74ef54928
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

<<<<<<< HEAD

=======
>>>>>>> f977738b85816bdc630f829195bd91e74ef54928

}
}
