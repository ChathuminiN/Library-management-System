package dao.custom;

import java.util.ArrayList;

import dao.CrudDao;
import entity.BorrowingEntity;

public interface BorrowingDao extends CrudDao<BorrowingEntity, String> {

    boolean save(BorrowingEntity entity)throws Exception;

    boolean delete(String borrID)throws Exception;

    boolean update(BorrowingEntity entity)throws Exception;

    ArrayList<BorrowingEntity> getAll()throws Exception;

    BorrowingEntity getBID(String borrID)throws Exception;;

    BorrowingEntity getMID(String borrMID)throws Exception;;
    
}
