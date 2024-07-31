package service.custom.impl;

import java.util.ArrayList;
import dao.DaoFactory;
import dao.custom.BookDao;
import dto.BookDto;
import entity.BookEntity;
import service.custom.BookService;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);

    @Override
    public String save(BookDto bookDto) throws Exception {
        BookEntity entity = getEntity(bookDto);
        return bookDao.save(entity) ? "Success" : "Fail";
    }

    private BookEntity getEntity(BookDto bookDto) {
        return  new BookEntity(
            bookDto.getBookID(), 
            bookDto.getTitle(),
            bookDto.getAuthor(), 
            bookDto.getCatId(), 
            bookDto.getYear(), 
            bookDto.getIsbn(), 
            bookDto.getCopiesa());
    }

    @Override
    public String delete(String bookID) throws Exception {
        return bookDao.delete(bookID) ? "Success" : "Fail";
    }

    @Override
    public BookDto get(String bookID) throws Exception {
        BookEntity entity = bookDao.get(bookID);
        if(entity != null){
            return getDto(entity);
        }
        return null;
    }

    private BookDto getDto(BookEntity entity) {
        return  new BookDto(
            entity.getBookID(), 
            entity.getTitle(),
            entity.getAuthor(), 
            entity.getCatId(), 
            entity.getYear(), 
            entity.getIsbn(), 
            entity.getCopiesa());
    }

    @Override
    public String update(BookDto bookDto) throws Exception {
        BookEntity entity = getEntity(bookDto);
        return bookDao.update(entity) ? "Success" : "Fail";
    }

    @Override
    public ArrayList<BookDto> getAll() throws Exception {
       ArrayList<BookEntity> bookEntities = bookDao.getAll();
        if(bookEntities != null && !bookEntities.isEmpty()){
            ArrayList<BookDto> bookDtos = new ArrayList<>();
            
            for (BookEntity bookEntity : bookEntities) {
                bookDtos.add(getDto(bookEntity));
            }
            
            return bookDtos;
        }
        return null;
    }

    


       
    
    
}
