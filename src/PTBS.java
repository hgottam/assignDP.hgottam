import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class PTBS {
    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Facade facade = new Facade();
        Map<String, String> authResponse = facade.login();
        System.out.println("Hello " + authResponse.get("PersonName"));

        facade.createProductList();
//        System.out.println("Select one product: ");
//        int productChoice = sc.nextInt();
//        String selectedProduct = productList[productChoice - 1];
//        System.out.println("selected product " + selectedProduct);
        System.out.println("Choose product type: ");
        System.out.println(" 0 - MeatProductMenu \n 1 - ProduceProductMenu");
        int productMenuChoice = sc.nextInt();

        System.out.println("Product Menu:");
        System.out.println("1.Show Menu \n 2. Add trading \n 3.View Tradings");
        int productMenuOption = sc.nextInt();
        ProduceProductMenu ppm = new ProduceProductMenu();
        MeatProductMenu mpm = new MeatProductMenu();
        switch (productMenuOption) {
            case 1:
                if (productMenuChoice == 1)
                    ppm.showMenu();
                else
                    mpm.showMenu();
            case 2:
                if (productMenuChoice == 1)
                    ppm.showAddButton();
                else
                    mpm.showAddButton();
            case 3:
                if (productMenuChoice == 1)
                    ppm.showViewButton();
                else
                    mpm.showViewButton();
        }

        System.out.println("Selected product menu as '" + (productMenuChoice == 1 ? "ProduceProductMenu" : "MeatProductMenu")
                + "' for '" + authResponse.get("PersonName") + "'");
    }
}
