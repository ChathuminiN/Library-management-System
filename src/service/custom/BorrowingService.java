package service.custom;

import java.util.ArrayList;

import dto.BorrowingDto;
import service.SuperService;

public interface BorrowingService extends SuperService {

    String save(BorrowingDto borrowingDto)throws Exception;

    String delete(String borrID)throws Exception;

    BorrowingDto getBID(String borrID)throws Exception;

    BorrowingDto getMID(String borrMID)throws Exception;

    String update(BorrowingDto borrowingDto)throws Exception;

    ArrayList<BorrowingDto> getAll()throws Exception;
    
}
