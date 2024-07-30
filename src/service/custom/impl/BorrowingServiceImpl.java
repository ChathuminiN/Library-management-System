package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.BorrowingDao;
import dto.BorrowingDto;
import entity.BorrowingEntity;
import service.custom.BorrowingService;

public class BorrowingServiceImpl implements BorrowingService {

    private BorrowingDao borrowingDao = (BorrowingDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BORROWINGS);


    @Override
    public String save(BorrowingDto borrowingDto) throws Exception {
        BorrowingEntity entity = getEntity(borrowingDto);
        return borrowingDao.save(entity) ? "Success" : "Fail";
    }

    private BorrowingEntity getEntity(BorrowingDto borrowingDto) {
        return  new BorrowingEntity(
            borrowingDto.getBorrID(),
            borrowingDto.getMid(),
            borrowingDto.getBookId(),
            borrowingDto.getBorrDate(),
            borrowingDto.getDueDate(),
            borrowingDto.getRtnDate(),
            borrowingDto.getFine()
           );
    }

    @Override
    public String delete(String borrID) throws Exception {
        return borrowingDao.delete(borrID) ? "Success" : "Fail";
    }

    @Override
    public BorrowingDto getBID(String borrID) throws Exception {
        BorrowingEntity entity = borrowingDao.getBID(borrID);
        if(entity != null){
            return getDto(entity);
        }
        return null;
    }

    private BorrowingDto getDto(BorrowingEntity entity) {
        return  new BorrowingDto(
            entity.getBorrID(),
            entity.getMid(),
            entity.getBookId(),
            entity.getBorrDate(),
            entity.getDueDate(),
            entity.getRtnDate(),
            entity.getFine()
           );
    }

    @Override
    public BorrowingDto getMID(String borrMID) throws Exception {
        BorrowingEntity entity = borrowingDao.getMID(borrMID);
        if(entity != null){
            return getDto(entity);
        }
        return null;
    }

    @Override
    public String update(BorrowingDto borrowingDto) throws Exception {
        BorrowingEntity entity = getEntity(borrowingDto);
        return borrowingDao.update(entity) ? "Success" : "Fail";
    }

    @Override
    public ArrayList<BorrowingDto> getAll() throws Exception {
        ArrayList<BorrowingEntity> Entities = borrowingDao.getAll();
        if(Entities != null && !Entities.isEmpty()){
            ArrayList<BorrowingDto> borrowingDtos = new ArrayList<>();
            
            for (BorrowingEntity entity : Entities) {
                borrowingDtos.add(getDto(entity));
            }
            
            return borrowingDtos;
        }
        return null;
    }
    
}
