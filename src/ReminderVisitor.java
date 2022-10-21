public class ReminderVisitor extends NodeVisitor{
    private Reminder m_Reminder;
    public  void visitProduct(Product product){
        System.out.println("Visited a product");
    }
    public  void visitTrading(Trading trading){
        ReminderVisitor nv=new ReminderVisitor();
        trading.accept(nv);
    }
    public  void visitFacade(Facade facade){
        facade.remind();
    }
}
