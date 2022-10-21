import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserInfoItem {
   public static HashMap<String, Person> userInfo;
    UserInfoItem(){
        userInfo=new HashMap<>();
    }

    public  void  createBuyers() {
        String buyerFile = "./src/BuyerInfo.txt";
        FileReader inputFile;
        ArrayList<Person> al = new ArrayList<>();
        try {
            inputFile = new FileReader(buyerFile);
            BufferedReader readProductInfo = new BufferedReader(inputFile);
            String user = readProductInfo.readLine();
            do {
                if (user == null)
                    break;
                String[] userValues = user.split(":");
                String userName = userValues[0];
                Person p = new Buyer(userName, 0);
                userInfo.put(userName, p);
                user = readProductInfo.readLine();
            } while (true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public  void createSellers(){
        String sellerFile = "./src/SellerInfo.txt";

        FileReader inputFile;
        try {
            inputFile = new FileReader(sellerFile);
            BufferedReader readProductInfo = new BufferedReader(inputFile);
            String user = readProductInfo.readLine();
            do{
                if (user == null)
                    break;

                String[] userValues = user.split(":");
                String userName = userValues[0];
                //Implementation of factory design pattern. Classes are instantiated based on person type(Buyer/Seller).
                Person p = new Seller(userName, 1);
                userInfo.put(userName,p);
                user = readProductInfo.readLine();
            } while (true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void createUserInfo(){
        createSellers();
        createBuyers();
    }

}
