package dto;

public class BorrowingDetailDto {
    String brrId;
    String bookId;
    public BorrowingDetailDto() {
    }
    public BorrowingDetailDto(String brrId, String bookId) {
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
        return "BorrowingDetailDto [brrId=" + brrId + ", bookId=" + bookId + "]";
    }
    
}
