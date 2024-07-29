package tm;

public class BookTM {
    private String bookID;
    private String title;
    private String author;
    private String catId;
    private Integer year;
    private String isbn;
    private Integer copiesa;
    public BookTM() {
    }
    public BookTM(String bookID, String title, String author, String catId, Integer year, String isbn,
            Integer copiesa) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.catId = catId;
        this.year = year;
        this.isbn = isbn;
        this.copiesa = copiesa;
    }
    public String getBookID() {
        return bookID;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getCatId() {
        return catId;
    }
    public Integer getYear() {
        return year;
    }
    public String getIsbn() {
        return isbn;
    }
    public Integer getCopiesa() {
        return copiesa;
    }
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setCatId(String catId) {
        this.catId = catId;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setCopiesa(Integer copiesa) {
        this.copiesa = copiesa;
    }
    @Override
    public String toString() {
        return "BookTM [bookID=" + bookID + ", title=" + title + ", author=" + author + ", catId=" + catId + ", year="
                + year + ", isbn=" + isbn + ", copiesa=" + copiesa + "]";
    }
    

    
    
   
    
    
}
