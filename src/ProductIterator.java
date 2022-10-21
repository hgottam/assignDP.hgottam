import java.util.ArrayList;
import java.util.HashMap;

public class ProductIterator implements ListIterator {
    //Implementation of Iterator design pattern
    public ArrayList<Product> allProductList;

    static int productPositionIndex=0;
    public ProductIterator(ArrayList<Product> productList) {
        this.allProductList=productList;
        productPositionIndex=0;
    }

    public boolean hasNext(){
        if(productPositionIndex < allProductList.size() &&
                allProductList.get(productPositionIndex) != null)
            return true;

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
    public Product getProduct(String productName){
        for(int i=0;i<allProductList.size();i++){
            if(allProductList.get(i).currentProductName.equals(productName))
                return allProductList.get(i);
        }
        return null;
    }
}
