package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.BorrowingDDao;
import dto.BorrowingDetailDto;
import entity.BorrowingDetailEntity;
import service.custom.BorrowingsDService;

public class BorrowingDServiceImpl implements BorrowingsDService {
     private BorrowingDDao borrowingDDao = (BorrowingDDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BORROWINGDETAILS);

    @Override
    public ArrayList<BorrowingDetailDto> getAll() throws Exception {
        ArrayList<BorrowingDetailEntity> Entities = borrowingDDao.getAll();
        if(Entities != null && !Entities.isEmpty()){
            ArrayList<BorrowingDetailDto> borrowingDetailDtos = new ArrayList<>();
            
            for (BorrowingDetailEntity entity : Entities) {
                borrowingDetailDtos.add(getDto(entity));
            }
            
            return borrowingDetailDtos;
        }
        return null;
    }

    @Override
    public BorrowingDetailDto getBorrID(String borrID) throws Exception {
        BorrowingDetailEntity entity = borrowingDDao.getBorrID(borrID);
        if(entity != null){
            return getDto(entity);
        }
        return null;
    }

    private BorrowingDetailDto getDto(BorrowingDetailEntity entity) {
        return  new BorrowingDetailDto(
            entity.getBrrId(),
            entity.getBookId()
           );
    }

    @Override
    public BorrowingDetailDto getBID(String bookID) throws Exception {
        BorrowingDetailEntity entity = borrowingDDao.getBookID(bookID);
        if(entity != null){
            return getDto(entity);
        }
        return null;
        
    }

    
}
