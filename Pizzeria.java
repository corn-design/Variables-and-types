public class  Pizzeria{
    private String storeName;
    
    public String storeAddress;
    private String storeEmail;
    public long storePhone;
    private String storeMenu;
    
    private String pizzaIngredients;
    private double pizzaPrice;
    private double sides;
    private String drinks;
    private String orderID;
    private double orderTotal;
    
    public void takeOrder (String id,String drinkName, double total, double side, double price, String ingredients){
        pizzaIngredients = ingredients;
        pizzaPrice = price;
        sides = side;
        drinks = drinkName;
        orderID = id;
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

    private void makePizza(){
        System.out.println("add ingredients");
        System.out.println("add drink");
    }
    private void printReceipt(){
        {
            System.out.println("*******RECEIPPT**********");
            
            System.out.println("Order ID"+orderID);
            System.out.println("pizzaPrice"+price);
            System.out.println("Order Total"+orderTotal);
            
            }
    }



} 