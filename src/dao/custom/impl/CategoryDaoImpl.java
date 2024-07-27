package dao.custom.impl;



import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.CategoryDao;
import entity.CategoryEntity;

public class CategoryDaoImpl implements CategoryDao {

    @Override
    public boolean create(CategoryEntity entity) throws Exception {
        
        return CrudUtil.executeUpdate("INSERT INTO bookcategories VALUES(?,?)", entity.getCatID(), entity.getCatName());
    }

    @Override
    public boolean delete(String catID) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM bookcategories WHERE CategoryID = ?",catID);
    }

    @Override
    public CategoryEntity get(String catID) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM bookcategories WHERE CategoryID = ?", catID);
        if (rst.next()) {
            CategoryEntity entity = new CategoryEntity(rst.getString("CategoryID"), rst.getString("CategoryName"));
            return entity;
        }
            return null;
    }

    @Override
    public boolean update(CategoryEntity entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE bookcategories SET CategoryName = ? WHERE CategoryID = ?", 
                entity.getCatName(),entity.getCatID());
    }

    @Override
    public ArrayList<CategoryEntity> getAll() throws Exception {
        ArrayList<CategoryEntity> categoryEntities = new ArrayList<>();
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM  bookcategories");
            while (rst.next()) {            
                CategoryEntity entity = new CategoryEntity(rst.getString("CategoryID"), 
                        rst.getString("CategoryName"));
                categoryEntities.add(entity);
            }
            return categoryEntities;
    }
    
    
    
}
