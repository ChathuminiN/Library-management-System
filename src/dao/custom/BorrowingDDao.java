package dao.custom;

import java.util.ArrayList;

import dao.CrudDao;
import entity.BorrowingDetailEntity;


public interface BorrowingDDao extends CrudDao<BorrowingDetailEntity, String>{

    BorrowingDetailEntity getBorrID(String borrID) throws Exception;
    ArrayList<BorrowingDetailEntity> getAll()throws Exception;
    BorrowingDetailEntity getBookID(String bookID)throws Exception;
    boolean save(BorrowingDetailEntity borrowingDetailEntity) throws Exception;
    
}
