 public class  SliceoHeaven{
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


    public final String DEF_ORDER_ID = "DEF-SOH-099"; 
    public final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    public final double DEF_ORDER_TOTAL =  15.00;



    public SliceoHeaven() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
    }
    public SliceOHeaven(String orderID, String pizzaIngredients, double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
        this.sides = "";
        this.drinks = "";
    }
     
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getPizzaIngredients() {
        return pizzaIngredients;
    }

    public void setPizzaIngredients(String pizzaIngredients) {
        this.pizzaIngredients = pizzaIngredients;
    }

    public String getSides() {
        return sides;
    }

    public void setSides(String sides) {
        this.sides = sides;
    }

    public String getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
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