import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class PTBS {
    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Implementing methods in facade and its design pattern
        Facade facade = new Facade();
        ArrayList<String> loginResponse = facade.login();
        System.out.println("Hello "+ loginResponse.get(1));

        //Implementation of iterator design pattern to define all products on the list
        UserInfoItem userInfoItem=new UserInfoItem();
        userInfoItem.createUserInfo();
        facade.createProductList();
        facade.AttachProductToUser();

        System.out.println("Choose product type: ");
        System.out.println(" 0 - MeatProductMenu \n 1 - ProduceProductMenu");
        int productMenuChoice = sc.nextInt();
        ProductMenu ppm ;
        //Implementation of factory design pattern. Classes are instantiated based on product type.
        if(productMenuChoice==1)
            ppm=new ProduceProductMenu();
        else if (productMenuChoice==0)
            ppm= new MeatProductMenu();
        else {
            System.out.println("Invalid option! Select again!!");
            productMenuChoice = sc.nextInt();
            ppm=null;
        }
        System.out.println("Selected product menu as " + (productMenuChoice == 1 ? "ProduceProductMenu" : "MeatProductMenu"));
        System.out.println();

        System.out.println("Select an option from below, respective to chosen menu type:");
        System.out.println(" 1.Show Menu \n 2. Add \n 3. View \n 4. Reminder \n 5. Exit");
        int productMenuOption = sc.nextInt();
        menuDriven(productMenuOption,facade,ppm);

        System.out.println();
        System.out.println("===========================================");
        System.out.println();

        //Implementation of bridge pattern. Displaying the items based on user type(Seller/Buyer)
        String user=loginResponse.get(0)=="0"?"Buyer":"Seller";
        System.out.println("As "+user+" you can perform any of the below actions");
        Person p;
        if(loginResponse.get(0)=="0"){
            p = new Buyer(loginResponse.get(1), 0);
        }
        else{
            p = new Seller(loginResponse.get(1), 1);
        }
        System.out.println("Select from:\n 1.Show Menu \n 2. Create Product Menu");
        int userOption=sc.nextInt();
        if(userOption==1)
            p.showMenu();
        else
            p.CreateProductMenu();

        System.out.println("End of application!");
    }
    public static void menuDriven(int productMenuOption,Facade facade,ProductMenu ppm){
        Scanner sc=new Scanner(System.in);
        switch (productMenuOption) {
            case 1:
                ppm.showMenu();
                break;
            case 2:
                ppm.showAddButton();
                break;
            case 3:
                ppm.showViewButton();
                break;
            case 4:
                //Implementing visitor pattern by using remind function in facade with help of reminderVisitor
                ReminderVisitor rv=new ReminderVisitor();
                rv.visitFacade(facade);
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Invalid option. Select Again");
                productMenuOption = sc.nextInt();
                menuDriven(productMenuOption,facade,ppm);
        }
    }
}
