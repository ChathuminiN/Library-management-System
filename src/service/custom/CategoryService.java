package service.custom;



import java.util.ArrayList;

import dto.CategoryDto;
import service.SuperService;

public interface CategoryService extends SuperService {

    String create(CategoryDto categoryDto) throws Exception;
    String delete(String catID)throws Exception;
    CategoryDto get(String catID)throws Exception;
    String update(CategoryDto categoryDto)throws Exception;
    ArrayList<CategoryDto> getAll()throws Exception;
    
    
    

    
    
}
