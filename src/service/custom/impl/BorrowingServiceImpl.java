package service.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.BookDao;
import dao.custom.BorrowingDDao;
import dao.custom.BorrowingDao;
import db.DBConnection;

import dto.BorrowingDto;
import entity.BookEntity;
import entity.BorrowingDetailEntity;
import entity.BorrowingEntity;
import service.custom.BorrowingService;

public class BorrowingServiceImpl implements BorrowingService {

    private BorrowingDao borrowingDao = (BorrowingDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BORROWINGS);
    private BorrowingDDao borrowingDDao = (BorrowingDDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BORROWINGDETAILS);
    private BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);
    
    @Override
    public String save(BorrowingDto borrowingDto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        try{
            connection.setAutoCommit(false);

            BorrowingEntity entity = new BorrowingEntity(
                borrowingDto.getBorrID(),
                borrowingDto.getMid(),
                borrowingDto.getBookId(),
                borrowingDto.getBorrDate(),
                borrowingDto.getDueDate(),
                borrowingDto.isReturn(),
                borrowingDto.getFine()
               );
               BorrowingDetailEntity borrowingDetailEntity =  new BorrowingDetailEntity(entity.getBorrID(),entity.getBookId());
            if(borrowingDao.save(entity)){
                boolean isBorrowingDetailSaved = borrowingDDao.save(
                                 borrowingDetailEntity   
                                );


                

                /*for(BorrowingDetailDto borrowingDetailDto:borrowingDto.getBorrowingDetailDtos()){
                   // BorrowingDetailEntity borrowingDetailEntity=new BorrowingDetailEntity(borrowingDetailDto.getBrrId(),
                    //borrowingDetailDto.getBookId());
                    if(!borrowingDDao.save(borrowingDetailEntity)){
                        isBorrowingDetailSaved=false;
                    }

                
                }*/

                if(isBorrowingDetailSaved){
                   
                   
                        BookEntity bookEntity=bookDao.get(entity.getBookId());
                        if(bookEntity!=null){
                            bookEntity.setCopiesa(bookEntity.getCopiesa()-1);
                            if(!bookDao.update(bookEntity)){
                                connection.rollback();
                                return "book update Failed";
                            }
                            else{
                                connection.commit();
                                return "Book update Success";
                            }
                        }
                        else{
                            return "can not find ";

                        }
                    
                    
                }else{
                    connection.rollback();
                    return "Borrowing Detail Save Error";

                }
                               
            }else{
                connection.rollback();
                    return "Borrowing  Save Error";

            }
        }catch(Exception e) {
            connection.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }


        
        
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
            entity.isReturn(),
            entity.getFine()
           );
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
