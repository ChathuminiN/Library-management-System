package dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import dao.CrudUtil;
import dao.custom.BookDao;
import entity.BookEntity;




public class BookDaoImpl implements BookDao {

    @Override
    public boolean save(BookEntity entity) throws Exception {
         return CrudUtil.executeUpdate("INSERT INTO books VALUES(?,?,?,?,?,?,?)",
          entity.getBookID(),
          entity.getTitle(),
          entity.getAuthor(),
          entity.getCatId(),
          entity.getIsbn(),
          entity.getYear(),
          entity.getCopiesa());
    }

    @Override
    public boolean delete(String bookID) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM books WHERE BookID = ?",bookID);
    }

    @Override
    public BookEntity get(String bookID) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM books WHERE BookID = ?", bookID);
        if (rst.next()) {
           
           BookEntity entity = new BookEntity(
            rst.getString("BookID"), 
            rst.getString("Title"),
            rst.getString("Author"), 
            rst.getString("CategoryID"), 
            rst.getInt("Year"), 
            rst.getString("ISBN"), 
            rst.getInt("CopiesAvailable"));
        
           return entity;
        }
            return null;
    }

    @Override
    public boolean update(BookEntity entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE books SET Title =?, Author =?,CategoryID =?,ISBN =?,Year =?,CopiesAvailable =? WHERE BookID = ?", 
        entity.getTitle(),
        entity.getAuthor(),
        entity.getCatId(),
        entity.getIsbn(),
        entity.getYear(),
        entity.getCopiesa(),
        entity.getBookID());
    }

    @Override
    public ArrayList<BookEntity> getAll() throws Exception {
        ArrayList<BookEntity> bookEntities = new ArrayList<>();
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM  books");
            while (rst.next()) {            
                BookEntity entity = new BookEntity(
                    rst.getString("BookID"), 
                    rst.getString("Title"),
                    rst.getString("Author"), 
                    rst.getString("CategoryID"), 
                    rst.getInt("Year"), 
                    rst.getString("ISBN"), 
                    rst.getInt("CopiesAvailable")
                    );
                bookEntities.add(entity);
            }
            
            return bookEntities;
        
    }
    
}
