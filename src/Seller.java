import java.util.ArrayList;
import java.util.HashMap;

public class Seller extends Person{

    public Seller(String personName,int  userType){
        this.personName=personName;
        this.userType=userType;
    }
    public void showMenu(){
    //According to the need of seller show the appropriate items on the menu.
        System.out.println("Items of current Seller:");
        HashMap<String,Person> allUserInfo=UserInfoItem.userInfo;
        try{
            if (this.personName == null)
                throw new Exception("Person Name not read properly!");
            ArrayList<Product> productListOfPerson = allUserInfo.get(this.personName).personProductList;
            for (int i = 0; i < productListOfPerson.size(); i++) {
                System.out.println(productListOfPerson.get(i).currentProductName + " of type " + productListOfPerson.get(i).currentProductType);
            }
        }
    catch(Exception e) {
        System.out.println(e.getMessage());
    }

    }
    public ProductMenu CreateProductMenu(){
        System.out.println("Method to create product menu");
        return null;
    }

}
