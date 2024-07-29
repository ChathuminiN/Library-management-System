package entity;

public class BorrowingEntity {
    private String borrID;
    private String mid;
    private String bookId;
    private String borrDate;
    private String dueDate;
    private String rtnDate;
    private Double fine;
    public BorrowingEntity() {
    }
    public BorrowingEntity(String borrID, String mid, String bookId, String borrDate, String dueDate, String rtnDate,
            Double fine) {
        this.borrID = borrID;
        this.mid = mid;
        this.bookId = bookId;
        this.borrDate = borrDate;
        this.dueDate = dueDate;
        this.rtnDate = rtnDate;
        this.fine = fine;
    }
    public String getBorrID() {
        return borrID;
    }
    public String getMid() {
        return mid;
    }
    public String getBookId() {
        return bookId;
    }
    public String getBorrDate() {
        return borrDate;
    }
    public String getDueDate() {
        return dueDate;
    }
    public String getRtnDate() {
        return rtnDate;
    }
    public Double getFine() {
        return fine;
    }
    public void setBorrID(String borrID) {
        this.borrID = borrID;
    }
    public void setMid(String mid) {
        this.mid = mid;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public void setBorrDate(String borrDate) {
        this.borrDate = borrDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    public void setRtnDate(String rtnDate) {
        this.rtnDate = rtnDate;
    }
    public void setFine(Double fine) {
        this.fine = fine;
    }
    @Override
    public String toString() {
        return "BorrowingEntity [borrID=" + borrID + ", mid=" + mid + ", bookId=" + bookId + ", borrDate=" + borrDate
                + ", dueDate=" + dueDate + ", rtnDate=" + rtnDate + ", fine=" + fine + "]";
    }
    

    
    
}
