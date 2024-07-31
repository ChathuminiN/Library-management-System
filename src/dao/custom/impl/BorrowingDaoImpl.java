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
        entity.isReturn(),
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
            rst.getDate("BorrowDate").toLocalDate(), 
            rst.getDate("DueDate").toLocalDate(),
            rst.getBoolean("isReturn"), 
            rst.getDouble("Fine")
            );
        
           return entity;
        }
        return null;
        
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
            rst.getDate("BorrowDate").toLocalDate(), 
            rst.getDate("DueDate").toLocalDate(),
            rst.getBoolean("isReturn"), 
            rst.getDouble("Fine")
            );
                Entities.add(entity);
            }
            
            return Entities;
    }
    
}
