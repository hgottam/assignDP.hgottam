import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login extends Facade{
    public HashMap<String, String> login(int UserType, Person thePerson){
        String loginStatus = "false";
        HashMap<String,String> hm=new HashMap<>();
        try {
            System.out.println("Enter Username");
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            String inputUsername = sc.nextLine();
            System.out.println("Enter Password");
            String inputPassword = sc.nextLine();
            boolean status = loginCheck("./src/SellerInfo.txt", inputUsername, inputPassword);
            if(status) {
                System.out.println("Logged in as seller!");
                loginStatus = "true";
                UserType = 1;
                Seller seller=new Seller();
                seller.personName=inputUsername;
                hm.put("PersonName", seller.personName);
            }
            else{
                boolean buyStatus = loginCheck("./src/BuyerInfo.txt", inputUsername, inputPassword);
                if (!buyStatus) {
                    throw new Exception("Invalid!");
                } else {
                    System.out.println("Logged in as Buyer!");
                    if (buyStatus) loginStatus = "true";
                    else loginStatus = "false";
                    UserType = 0;
                    Buyer buyer=new Buyer();
                    buyer.personName=inputUsername;
                    hm.put("PersonName", buyer.personName);
                }
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
            login(UserType, thePerson);
        }
        hm.put("loginStatus",loginStatus);

        return hm;
    }
    private boolean isLoginStatus(boolean loginStatus, boolean checkPassword) {
        if (!checkPassword) {
            System.out.println("Invalid Username/Password");
            login();
        } else {
            System.out.println("Login success");
            loginStatus = true;
        }
        return loginStatus;
    }
    public boolean loginCheck(String inputFileType, String inputUsername, String inputPassword) {
        boolean loginStatus = false;
        try {
            boolean found = false;
            FileReader fileReader = new FileReader(inputFileType);
            @SuppressWarnings("resource")
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String creds = bufferedReader.readLine();
            while (true) {
                if (creds == null) break;
                String username = getString(creds);
                if (!isEqualsIgnoreCase(inputUsername, username)) {
                } else {
                    found = true;
                    boolean checkPassword = isPassword(inputPassword, creds);
                    loginStatus = isLoginStatus(loginStatus, checkPassword);
                }
                creds = getBufferedReader(bufferedReader).readLine();
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
        String password = getPassword(creds);
        boolean checkPassword = isCheckPassword(inputPassword, password);
        return checkPassword;
    }

    private boolean isEqualsIgnoreCase(String inputUsername, String username) {
        return username.equalsIgnoreCase(inputUsername);
    }

    private BufferedReader getBufferedReader(BufferedReader bufferedReader) {
        return bufferedReader;
    }

    private boolean isCheckPassword(String inputPassword, String password) {
        boolean checkPassword = inputPassword.equals(password);
        return checkPassword;
    }

    private String getPassword(String creds) {
        String password = creds.substring(creds.lastIndexOf(":") + 1);
        return password;
    }

    private String getString(String creds) {
        String username = creds.substring(0, creds.indexOf(":"));
        return username;
    }
}
