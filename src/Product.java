public class Product extends ClassProductList{
    String currentProductType,currentProductName;
    public Product(String currentProductType,String currentProductName) {
        this.currentProductName = currentProductName;
        this.currentProductType=currentProductType;
    }

    public String getCurrentProductName() {
        return currentProductName;
    }

    public void setCurrentProductName(String currentProductName) {
        this.currentProductName = currentProductName;
    }

}
