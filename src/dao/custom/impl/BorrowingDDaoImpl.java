package dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.BorrowingDDao;
import entity.BorrowingDetailEntity;



public class BorrowingDDaoImpl implements BorrowingDDao {

    @Override
    public BorrowingDetailEntity getBorrID(String borrID) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM borrowingsDetails WHERE BorrowingID = ?", borrID);
        if (rst.next()) {
           
            BorrowingDetailEntity entity = new BorrowingDetailEntity(
            rst.getString("BookID"),
            rst.getString("BorrowingID")
            
            );
        
           return entity;
        }
        return null;
    }

    @Override
    public ArrayList<BorrowingDetailEntity> getAll() throws Exception {
        ArrayList<BorrowingDetailEntity> Entities = new ArrayList<>();
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM  borrowingsDetails");
            while (rst.next()) {            
                BorrowingDetailEntity entity = new BorrowingDetailEntity(
                    rst.getString("BorrowingID"),                    
                    rst.getString("BookID")
                    
            );
                Entities.add(entity);
            }
            
            return Entities;
    }

    @Override
    public BorrowingDetailEntity getBookID(String bookID) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM borrowingsDetails WHERE BookID = ?", bookID);
        if (rst.next()) {
           
            BorrowingDetailEntity entity = new BorrowingDetailEntity(
            rst.getString("BookID"),
            rst.getString("BorrowingID")
            
            );
        
           return entity;
        }
        return null;
    }

    @Override
    public boolean save(BorrowingDetailEntity borrowingDetailEntity) throws Exception {
        System.out.println(borrowingDetailEntity);
        
        return CrudUtil.executeUpdate("INSERT INTO borrowingsdetails VALUES(?,?)",borrowingDetailEntity.getBrrId(),borrowingDetailEntity.getBookId());
        
    }
    
}
