package dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import dao.CrudUtil;
import dao.custom.BorrowingDao;
import entity.BorrowingEntity;


public class BorrowingDaoImpl implements BorrowingDao {

    @Override
    public boolean save(BorrowingEntity entity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO borrowings VALUES(?,?,?,?,?,?,?)",
        entity.getBorrID(),
        entity.getMid(),
        entity.getBookId(),
        entity.getBorrDate(),
        entity.getDueDate(),
        entity.getRtnDate(),
        entity.getFine());
    }

    @Override
    public boolean delete(String borrID) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM borrowings WHERE BorrowingID = ?",borrID);
    }

    @Override
    public BorrowingEntity getBID(String borrID) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM borrowings WHERE BorrowingID = ?", borrID);
        if (rst.next()) {
           
           BorrowingEntity entity = new BorrowingEntity(
            rst.getString("BorrowingID"),
            rst.getString("MemberID"),
            rst.getString("BookID"), 
            rst.getString("BorrowDate"), 
            rst.getString("DueDate"),
            rst.getString("ReturnDate"), 
            rst.getDouble("Fine")
            );
        
           return entity;
        }
        return null;
        
    }

    @Override
    public BorrowingEntity getMID(String MID) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM borrowings WHERE BorrowingID = ?", MID);
        if (rst.next()) {
           
           BorrowingEntity entity = new BorrowingEntity(
            rst.getString("BorrowingID"),
            rst.getString("MemberID"),
            rst.getString("BookID"), 
            rst.getString("BorrowDate"), 
            rst.getString("DueDate"),
            rst.getString("ReturnDate"), 
            rst.getDouble("Fine")
            );
        
           return entity;
        }
        return null;
        
    }

    @Override
    public boolean update(BorrowingEntity entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE borrowings SET MemberID =?, BookID =?, BorrowDate =?,DueDate=?, ReturnDate =? WHERE  BorrowingID = ?", 
        entity.getMid(),
        entity.getBookId(),
        entity.getBorrDate(),
        entity.getDueDate(),
        entity.getRtnDate(),
        entity.getFine(),
        entity.getBorrID());
    }

    @Override
    public ArrayList<BorrowingEntity> getAll() throws Exception {
        ArrayList<BorrowingEntity> Entities = new ArrayList<>();
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM  borrowings");
            while (rst.next()) {            
                BorrowingEntity entity = new BorrowingEntity(
                    rst.getString("BorrowingID"),
                    rst.getString("MemberID"),
                    rst.getString("BookID"), 
                    rst.getString("BorrowDate"), 
                    rst.getString("DueDate"),
                    rst.getString("ReturnDate"), 
                    rst.getDouble("Fine")
            );
                Entities.add(entity);
            }
            
            return Entities;
    }
    
}
