package service.custom;

import java.util.ArrayList;

import dto.BorrowingDto;
import service.SuperService;

public interface BorrowingService extends SuperService {

    String save(BorrowingDto borrowingDto)throws Exception;

    BorrowingDto getBID(String borrID)throws Exception;

    ArrayList<BorrowingDto> getAll()throws Exception;
    
}
