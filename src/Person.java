import java.util.ArrayList;

public abstract class Person {
    private ProductMenu theProductMenu;
    String personName;
    int userType;
    ArrayList<Product> personProductList;
    public abstract void showMenu();
    public void showAddButton(){
      //Call the implementation to show the "add" buttons.
    }
    public void showViewButton(){
      //Call the implementation to show the "view" buttons.
    }
    public void showRadioButton(){
      //Call the implementation to show the radio buttons.
    }
    public void showLabels(){
      //Call the implementation to show the labels.
    }
    public abstract ProductMenu CreateProductMenu();
}
