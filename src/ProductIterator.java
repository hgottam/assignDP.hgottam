import java.util.ArrayList;
import java.util.HashMap;

public class ProductIterator implements ListIterator {
    ArrayList<Product> allProductList;
    static final int maximum_allowed_products=20;
    static int productPositionIndex=0;
    public ProductIterator(ArrayList<Product> productList) {
        this.allProductList=productList;
        productPositionIndex=0;
    }

    public boolean hasNext(){
        if(productPositionIndex < allProductList.size() &&
                allProductList.get(productPositionIndex) != null)
            return true;
        else
            return false;
    }
    public Product Next(){
        Product productName=allProductList.get(productPositionIndex++);
        return productName;
    }
    public void MoveToHead(){
        productPositionIndex=0;
    }
    public void Remove(){
        
    }
}
