import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login extends Facade{
    public ArrayList<String> login(){
        //This method returns an arraylist with logged-in username and type of the user(0-buyer, 1-seller)
        // and also check if the logged-in user is already existing in the file.
        // The Method iterates through sellerInfo.txt and buyerInfo.txt files to identify the user and validates the person.
        boolean loginStatus = false;
        Facade facade=new Facade();
        ArrayList<String> al=new ArrayList<>();
        String userType="";
        try {
            System.out.println("Enter Username");
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            String inputUsername = sc.nextLine();
            System.out.println("Enter Password");
            String inputPassword = sc.nextLine();
            boolean status = loginCheck("./src/SellerInfo.txt", inputUsername, inputPassword);
            if(status) {
                System.out.println("Current usertype: Seller");
                loginStatus = true;
                userType="1";
            }
            else{
                boolean buyStatus = loginCheck("./src/BuyerInfo.txt", inputUsername, inputPassword);
                if (!buyStatus) {
                    al.clear();
                    System.out.println("Invalid!");
                    login();
                } else {
                    System.out.println("Current usertype: Buyer");
                    if (buyStatus) loginStatus = true;
                    else loginStatus = false;
                    userType="0";
                }
            }
            al.add(userType);
            al.add(inputUsername);
        }catch(Exception e) {
            System.out.println(e.getMessage());
            login();
        }

        return al;
    }
    private boolean LoginStatus(boolean loginStatus, boolean checkPassword) {
        //this method checks if login is valid or invalid.
        if (!checkPassword) {
            System.out.println("Invalid Username/Password");
            login();
        } else {
            System.out.println("Login successful");
            loginStatus = true;
        }
        return loginStatus;
    }
    public boolean loginCheck(String inputFileType, String inputUsername, String inputPassword) {
        //Method used by the login() for validation based on file.
        boolean loginStatus = false;
        try {
            boolean found = false;
            FileReader fileReader = new FileReader(inputFileType);
            @SuppressWarnings("resource")
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String creds = bufferedReader.readLine();
            while (true) {
                if (creds == null) break;
                String username =creds.substring(0, creds.indexOf(":"));
                if (!isEqualsIgnoreCase(inputUsername, username)) {
                } else {
                    found = true;
                    boolean checkPassword = isPassword(inputPassword, creds);
                    loginStatus = LoginStatus(loginStatus, checkPassword);
                }
                creds = bufferedReader.readLine();
            }
            if (found) {
            } else {
                return found;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            login();
        }
        return loginStatus;
    }
    private boolean isPassword(String inputPassword, String creds) {
        String password = creds.substring(creds.lastIndexOf(":") + 1);
        boolean checkPassword = inputPassword.equals(password);
        return checkPassword;
    }

    private boolean isEqualsIgnoreCase(String inputUsername, String username) {
        return username.equalsIgnoreCase(inputUsername);
    }


}
