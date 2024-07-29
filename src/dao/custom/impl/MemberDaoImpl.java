package dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import dao.CrudUtil;
import dao.custom.MemberDao;
import entity.MemberEntity;

public class MemberDaoImpl implements MemberDao {


    @Override
    public boolean save(MemberEntity entity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO members VALUES(?,?,?,?,?,?)",
          entity.getMemberID(),
          entity.getMemberName(),
          entity.getDob(),
          entity.getAdrress(),
          entity.getContact(),
          entity.getEmail());

    }

    @Override
    public boolean delete(String memID) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM members WHERE MemberID = ?",memID);
    
    }

    @Override
    public MemberEntity get(String memID) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM members WHERE MemberID = ?", memID);
        if (rst.next()) {
           
           MemberEntity entity = new MemberEntity(
            rst.getString("MemberID"), 
            rst.getString("Name"),
            rst.getString("DOB"), 
            rst.getString("Address"), 
            rst.getString("ContactNumber"), 
            rst.getString("Email")
            );
        
           return entity;
        }
            return null;
    }

    @Override
    public boolean update(MemberEntity entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE members SET Name =?, DOB =?,Address =?,ContactNumber=?,Email =? WHERE MemberID = ?", 
        entity.getMemberName(),
        entity.getDob(),
        entity.getAdrress(),
        entity.getContact(),
        entity.getEmail(),
        entity.getMemberID());
    }

    @Override
    public ArrayList<MemberEntity> getAll() throws Exception {
        ArrayList<MemberEntity> Entities = new ArrayList<>();
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM  members");
            while (rst.next()) {            
                MemberEntity entity = new MemberEntity(
                    rst.getString("MemberID"), 
                    rst.getString("Name"),
                    rst.getString("DOB"), 
                    rst.getString("Address"), 
                    rst.getString("ContactNumber"), 
                    rst.getString("Email")
                    );
                Entities.add(entity);
            }
            
            return Entities;
    }

    @Override
    public MemberEntity getN(String memName) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM members WHERE Name = ?", memName);
        if (rst.next()) {
           
           MemberEntity entity = new MemberEntity(
            rst.getString("MemberID"), 
            rst.getString("Name"),
            rst.getString("DOB"), 
            rst.getString("Address"), 
            rst.getString("ContactNumber"), 
            rst.getString("Email")
            );
        
           return entity;
        }
            return null;
    }
    
}
