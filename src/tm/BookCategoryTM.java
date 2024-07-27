package tm;

public class BookCategoryTM {
    private String catID;
    private String catName;

    public BookCategoryTM() {
    }

    public BookCategoryTM(String catID, String catName) {
        this.catID = catID;
        this.catName = catName;
    }

    public String getCatID() {
        return catID;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatID(String catID) {
        this.catID = catID;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "BookCategoryTM [catID=" + catID + ", catName=" + catName + "]";
    }
    
}
