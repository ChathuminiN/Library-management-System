package dto;

import java.time.LocalDate;


public class BorrowingDto {

    
    private String borrID;
    private String mid;
    private String bookId;
    private LocalDate borrDate;
    private LocalDate dueDate;
    private boolean isReturn;
    private Double fine;
    public BorrowingDto() {
    }
    public BorrowingDto(String borrID, String mid, String bookId, LocalDate borrDate, LocalDate dueDate,
            boolean isReturn, Double fine) {
        this.borrID = borrID;
        this.mid = mid;
        this.bookId = bookId;
        this.borrDate = borrDate;
        this.dueDate = dueDate;
        this.isReturn = isReturn;
        this.fine = fine;
    }
    public String getBorrID() {
        return borrID;
    }
    public void setBorrID(String borrID) {
        this.borrID = borrID;
    }
    public String getMid() {
        return mid;
    }
    public void setMid(String mid) {
        this.mid = mid;
    }
    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public LocalDate getBorrDate() {
        return borrDate;
    }
    public void setBorrDate(LocalDate borrDate) {
        this.borrDate = borrDate;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public boolean isReturn() {
        return isReturn;
    }
    public void setReturn(boolean isReturn) {
        this.isReturn = isReturn;
    }
    public Double getFine() {
        return fine;
    }
    public void setFine(Double fine) {
        this.fine = fine;
    }
    @Override
    public String toString() {
        return "BorrowingDto [borrID=" + borrID + ", mid=" + mid + ", bookId=" + bookId + ", borrDate=" + borrDate
                + ", dueDate=" + dueDate + ", isReturn=" + isReturn + ", fine=" + fine + "]";
    }
    
    
    

   

    


    
    
    
    

    
}
