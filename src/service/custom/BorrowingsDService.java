package service.custom;
import java.util.ArrayList;
import dto.BorrowingDetailDto;
import service.SuperService;

public interface BorrowingsDService extends SuperService {

   

    ArrayList<BorrowingDetailDto> getAll()throws Exception;

    BorrowingDetailDto getBorrID(String borrID)throws Exception;

    BorrowingDetailDto getBID(String bookID)throws Exception;
    
}
