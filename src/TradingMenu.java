public class  TradingMenu {
    int userType;
    public void showTradingMenu(int userType){
        if(userType==0)
            System.out.println("Display Buyer Trading Menu");
        else
            System.out.println("Display Seller Trading Menu");
    }

}
