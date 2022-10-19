import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
class Facade{
    private int UserType, nProductCategory;
    private Product theSelectedProduct;
    private ClassProductList theProductList;
    private Person thePerson;

    public HashMap<String,String> login(){
        Login login=new Login();
        HashMap<String,String> hm=login.login(UserType,thePerson);
        return hm;
    }
    public void addTrading(){

    }
    public void viewTrading(){

    }
    public void decideBidding(){

    }
    public void discussBidding(){

    }
    public void submitBidding(){

    }
    public void remind(){

    }
    public void createUser(UserInfoItem userinfoitem){

    }
    public void createProductList(){
        String inputProductFile = "./src/ProductInfo.txt";
        FileReader productInfoFile;
        String[] productList = new String[15];
        int i = 0;
        try {
            productInfoFile = new FileReader(inputProductFile);
            BufferedReader readProductInfo = new BufferedReader(productInfoFile);
            String product = readProductInfo.readLine();
            if( ClassProductList.allProducts==null)
                ClassProductList.allProducts= new ArrayList<>();
            do {
                if (product == null)
                    break;
                //create product object instead of productlist
                String[] productValues=product.split(":");
                Product p=new Product(productValues[0],productValues[1]);
                System.out.println( productValues[0]+" "+productValues[1]);
                ClassProductList.allProducts.add(p);
                productList[i++] = product;
                product = readProductInfo.readLine();
            } while (true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        ProductIterator productIterator = getProductIterator(productList);
//        do {
//            if (!productIterator.hasNext())
//                break;
//            for (Map.Entry<Integer, String> entry : productIterator.next().entrySet()) {
//                Integer key = entry.getKey();
//                String value = entry.getValue();
//                System.out.println(" " + key + " : " + value);
//            }
//        } while (true);
    }
    public void AttachProductToUser() {
    }
    public Product SelectProduct(){

        return new Product(null,null);
    }
    public void productOperation(){

    }

}