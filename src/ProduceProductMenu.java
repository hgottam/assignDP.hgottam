import java.util.ArrayList;

public class ProduceProductMenu implements ProductMenu{
    public  void showMenu(){
        ArrayList<Product> al=ClassProductList.allProducts;
        ProductIterator productIterator=new ProductIterator(al);
        System.out.println("The Produce Product menu:");
        while(productIterator.hasNext()){
            Product product=productIterator.Next();
            if(product.currentProductType.equals("Produce")){
                System.out.println(product.currentProductName);
            }
        }
    }
    public void showAddButton(){

    }
    public void showViewButton(){

    }
    public void showRadioButton(){

    }
    public void showLabels(){

    }
    public void showComboxes(){
        
    }
}
