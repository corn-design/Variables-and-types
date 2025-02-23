public class LuckinCoffee {
    public String storeAddress;

    private String menu;

    public String storeHouse;
    public long storePhoneNumber;
    public String storeEmail;
    public String storeWebsite;
    

    private String orderID;
    private String orderDetails;
    private String orderStatus;
    private double orderTotal;

    public void takeOrder(String id,String details, double total){//orderTotal
        orderID = id;
        orderDetails = details;
        orderTotal = total;
        
        System.out.println("Order accepted!");

        System.out.println("Order is being prepared");

        try{
            Thread.sleep(5000);/*5seconds */
           
        }catch(InterruptedException e){
            System.out.println("for pickup");
        }

        System.out.println("ready");

        printReceipt();


    }

    private void printReceipt(){
        System.out.println("*******RECEIPPT**********");

        System.out.println("Order ID"+orderID);
        System.out.println("Order Details"+orderDetails);
        System.out.println("Order Total"+orderTotal);

    }



}