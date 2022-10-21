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
        //Add button to add the product to trade
        //For simplicity accepting the trade
    }
    public void showAddButton(){
        Facade facade=new Facade();
        //Product Menu: Method to add functionality for adding trading
        facade.addTrading();
    }
    public void showViewButton(){
        Facade facade=new Facade();
        //Product Menu: Method to add functionality to view the trades
        facade.viewTrading();
    }
    public void showRadioButton(){

    }
    public void showLabels(){

    }
    public void showComboxes(){
        
    }
}
