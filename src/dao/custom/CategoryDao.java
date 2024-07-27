package dao.custom;

import java.util.ArrayList;

import dao.CrudDao;
import entity.CategoryEntity;

public interface CategoryDao extends CrudDao<CategoryEntity, String>{

    boolean create(CategoryEntity entity)throws Exception;
    boolean delete(String catID)throws Exception;
    CategoryEntity get(String catID)throws Exception;
    boolean update(CategoryEntity entity)throws Exception;
    ArrayList<CategoryEntity> getAll()throws Exception;

     
    
    
    
    
}
