package controller;







import java.util.ArrayList;
import java.util.Locale.Category;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;

import dto.CategoryDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import service.ServiceFactory;
import service.custom.CategoryService;
import tm.BookCategoryTM;




public class CategoryController {
    


    public CategoryController() throws Exception {
        loadTable();
    }

    @FXML
    private JFXButton btnCreate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colCatName;

    @FXML
    private TableColumn<?, ?> colCatId;

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
    

    @FXML
    private JFXButton btnSearch;

    

    /////////////////////////////Action Buttons controlling//////////////////////////////////////
     @FXML
    void btnCreateOnAction(ActionEvent event) throws Exception {
        System.out.println("Create Cat");
        create();       
        
    }

    private CategoryService categoryService = (CategoryService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CATEGORY);

    private void create() throws Exception {
        try {
            String catId = txtCatId.getText();
            String catName = txtCatName.getText();
    
            if (catId != null && !catId.isEmpty() && catName != null && !catName.isEmpty()) {
                CategoryDto categoryDto = new CategoryDto(catId, catName);
                String resp = categoryService.create(categoryDto);
    
                showAlert(AlertType.INFORMATION, "Status", resp);
                clearForm();
                loadTable();
            } else {
                showAlert(AlertType.WARNING, "Error", "Please enter both ID and Name");
            }
        } catch (Exception e) {
            
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "An error occurred: " + e.getMessage());
        }
    }
    

    

    private void loadTable() {



    
        
    }



    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        System.out.println("Delete Cat");
        try {
            String catID = txtCatId.getText();            
            String resp = categoryService.delete(catID);
            
            if ("Success".equals(resp)) {
                System.out.println("Category deleted successfully.");
                showAlert(AlertType.INFORMATION, "Status", "Category deleted successfully.");
                
            } else {
                System.out.println("Failed to delete category: " + resp);
                showAlert(AlertType.ERROR, "Delete Failed", "Failed to delete category: " + resp);
            }
    
            clearForm();
            loadTable();
        } catch (Exception e) {
            
            showAlert(AlertType.ERROR, "Error", "An error occurred while deleting the category: " + e.getMessage());
        }
    }
    
    @FXML
    void btnEditOnAction(ActionEvent event) {
        System.out.println("Edit Cat");
        update();

    }

    
    private void update() {
        try {
            if (txtCatId.getText() != null && !txtCatId.getText().isEmpty() && txtCatName.getText() != null && !txtCatName.getText().isEmpty()) {
                CategoryDto categoryDto = new CategoryDto(txtCatId.getText(),txtCatName.getText());
                String resp = categoryService.update(categoryDto);
                showAlert(AlertType.INFORMATION, "Status", resp);
                clearForm();
                loadTable();
            }else{
                showAlert(AlertType.ERROR, "Error", "Please Enter both ID and Name");

            }       
                                   
        } catch (Exception e) {
            showAlert(AlertType.ERROR, "Error", "An error occurred while updating the category: " + e.getMessage());
           
        }
    }




    @FXML
    void btnSearchOnAction(ActionEvent event) {
        System.out.println("clicked on search");
        search();

    }

    private void search() {
        try {
            String catID=txtCatId.getText();            
            CategoryDto dto = categoryService.get(catID);
    
                if (dto != null) {                    
                    txtCatName.setText(dto.getCatName());
                } else {
                    showAlert(Alert.AlertType.WARNING, "Not Found", "Category not found.");
                }
            
            
        } catch (Exception e) {
            
            showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while searching for the category: " + e.getMessage());
        }
    }

    public void initialize() throws Exception{
        colCatId.setCellValueFactory(new PropertyValueFactory<>("Category Id"));
        colCatName.setCellValueFactory(new PropertyValueFactory<>("Category Name"));
        getAll();
    }



    private void getAll() throws Exception{
        ArrayList<Category> categoryList = new ArrayList<Category>();
        categoryList=categoryService.getAll();
        ObservableList<BookCategoryTM> CategoryTMList = FXCollections.observableArrayList();

      for(Category cat:categoryList){
        
        BookCategoryTM categoryTM = new BookCategoryTM(
                    cat.getCatID(),
                    cat.getCatName()
                    
                );
        CustomerTMList.add(customerTM);

      }
      System.out.println(CustomerTMList);
      tblCustomer.setItems(CustomerTMList);
       
    }




    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearForm() {
        txtCatId.setText("");
        txtCatName.setText("");
        
    }


}


