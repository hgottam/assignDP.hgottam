import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
class Facade{
    private int UserType, nProductCategory;
    private Product theSelectedProduct;
    private ClassProductList theProductList;
    private Person thePerson;

    public ArrayList<String> login(){
        //This method delegates all login required validations to Login class.
        Login login=new Login();
             return login.login();
    }
    public Person getPerson(){
        return thePerson;
    }
    public void setPerson(Person person){
        Person o=person;
        this.thePerson=o;
    }
    public Person getUserType(){
        return thePerson;
    }
    public void setUserType(int userType){
        this.UserType=userType;
    }

    public void addTrading(){
        //Facade: Method that gives information about adding a trade for the product.
        Trading trading=new Trading();
        trading.addTrading();
        //Implementing visitor pattern to visit all the tradings and
        // accept a trade or remind that the trade is ending.
        ReminderVisitor rv= new ReminderVisitor();
        rv.visitTrading(trading);
    }
    public void viewTrading(){
        //Facade: Method that gives information about the trading.
        // Calls BuyerTradingMenu/SellerTradingMenu based on the user"
        TradingMenu tradingMenu=new TradingMenu();
        tradingMenu.showTradingMenu(UserType);
    }
    public void decideBidding(){

    }
    public void discussBidding(){

    }
    public void submitBidding(){

    }
    public void remind(){
        //From ReminderVisitor function
        System.out.println("Remind function to remind users about the trade");
    }
    public void createUser(UserInfoItem userinfoitem){
    }
    public void createProductList(){
        //This method creates a list of all products that are present in the ProductInfo.txt file
        try {
            String inputProductFile= "./src/ProductInfo.txt";
            FileReader userProductFile = new FileReader(inputProductFile);
            BufferedReader readProductInfo = new BufferedReader(userProductFile);
            String product = readProductInfo.readLine();
            if(ClassProductList.allProducts==null)
                ClassProductList.allProducts=new ArrayList<>();
            do{
                if (product == null)
                    break;
                String[] values=product.split(":");
                Product p=new Product(values[0],values[1]);
                ClassProductList.allProducts.add(p);
                product = readProductInfo.readLine();
            } while (true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void AttachProductToUser() {
        //This method reads UserProduct.txt file and attaches products that are associated with the user.
        //if the user is a new user a new product list if created and attached to the user.
       HashMap<String,Person>hm= UserInfoItem.userInfo;
        try {
            String inputProductFile= "./src/UserProduct.txt";
            FileReader userProductFile = new FileReader(inputProductFile);
            BufferedReader readProductInfo = new BufferedReader(userProductFile);
            String line = readProductInfo.readLine();
            do{
                if (line == null)
                    break;
                String[] values=line.split(":");
                String personName=values[0];
                String productName=values[1];
                Product product=null;
                for(int i=0;i<ClassProductList.allProducts.size();i++){
                    if(ClassProductList.allProducts.get(i).currentProductName.equals(productName))
                        product= ClassProductList.allProducts.get(i);
                }

                if(hm.containsKey(personName)){
                    Person p=hm.get(personName);
                    if(p.personProductList==null) {
                        p.personProductList = new ArrayList<>();
                        p.personProductList.add(product);
                    }
                    else
                        p.personProductList.add(product);
                }
                line = readProductInfo.readLine();
            } while (true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Product SelectProduct(){
        //Method to return current selected Product
        System.out.println("Return current product");
        return new Product(null,null);
    }
    public void productOperation(){

    }

}