package tm;

public class BorrowingDTM {
    String brrId;
    String bookId;
    public BorrowingDTM() {
    }
    public BorrowingDTM(String brrId, String bookId) {
        this.brrId = brrId;
        this.bookId = bookId;
    }
    public String getBrrId() {
        return brrId;
    }
    public void setBrrId(String brrId) {
        this.brrId = brrId;
    }
    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    @Override
    public String toString() {
        return "BorrowingDTM [brrId=" + brrId + ", bookId=" + bookId + "]";
    }

    
}
