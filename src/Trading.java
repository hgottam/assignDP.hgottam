public class Trading {
    public void accept(ReminderVisitor visitor){
        System.out.println("Trade accepted");
    }
    public void addTrading(){
        System.out.println("Takes trading information and creates a new trade");
    }
}
