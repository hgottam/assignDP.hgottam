import java.util.ArrayList;

public class MeatProductMenu implements ProductMenu{
    public void showMenu(){
        ArrayList<Product> al=ClassProductList.allProducts;
        ProductIterator productIterator=new ProductIterator(al);
        System.out.println("The Meat Product menu:");
        while(productIterator.hasNext()){
            Product product=productIterator.Next();
            if(product.currentProductType.equals("Meat")){
                System.out.println(product.currentProductName);
            }
        }
    }
    public void showAddButton(){
        Facade facade=new Facade();
        //Product Menu: Method to add functionality for adding trading
        facade.addTrading();
        //For simplicity purpose accepting every trade that is added.
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
