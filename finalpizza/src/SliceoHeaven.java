import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class SliceoHeaven {
    public String storeAddress;
    public long storePhone;
    private String pizzaIngredients;
    private String orderID;
    private double orderTotal;

    public final String DEF_ORDER_ID = "DEF-SOH-099";
    public final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    public final double DEF_ORDER_TOTAL = 15.00;

    public SliceoHeaven() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
    }

    public SliceoHeaven(String orderID, String pizzaIngredients, double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
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

    public void takeOrder() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter three ingredients for your pizza (use spaces to separate ingredients):");
        String[]ingredients = input.nextLine().split("");
        String ing1 = ingredients[0];
        String ing2 = ingredients[1];
        String ing3 = ingredients[2];    


        System.out.println("Enter size of pizza (Small, Medium, Large):");
        String pizzaSize = input.next();
        
        System.out.println("Do you want extra cheese (Y/N):");
        String extraCheese = input.nextLine();

        System.out.println("Enter one side dish (Calzone, Garlic bread, None):");
        String sideDish = input.nextLine();

        System.out.println("Enter drinks(Cold Coffee, Cocoa drink, Coke, None):");
        String drinks = input.nextLine();

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String wantDiscount = input.nextLine();

        if("y".equalsIgnoreCase(wantDiscount)){
            isItYourBirthday();
            }
           else{
            makeCardPayment();
           }
      
            input.close();
            
        }
        public void isItYourBirthday(){
            Scanner yourbirthday = new Scanner(System.in);
            
            System.out.println("Please enter your birthday (in the format yyyy-mm-dd):");
            String birthdateStr = yourbirthday.nextLine();
            String years = birthdateStr.substring(0,4) ;
            String months = birthdateStr.substring(5,7);
            String days = birthdateStr.substring(8, 10);
                
                int year = Integer.parseInt(years);
                int month = Integer.parseInt(months);
                int day = Integer.parseInt(days);
    
                LocalDate dob = LocalDate.of(year, month, day);
                LocalDate now = LocalDate.now();
    
                Period period = Period.between(dob, now);
                int age = period.getYears();
                
                if (age < 18 && dob.getDayOfYear() == now.getDayOfYear() && dob.getYear() == now.getYear()) {
                    System.out.println("Congratulations! You pay only half the price for your order");
                } else {
                    System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
                }

            yourbirthday.close();

        }
        public void makeCardPayment(){
            Scanner CardPayment = new Scanner(System.in);
            
            System.out.println("Give the card number");
            long cardNumber = CardPayment.nextLong();
            
            System.out.println("Give the card's expiry date(year and month)");
            String expiryDate = CardPayment.nextLine();

            System.out.println("Give the cvv(3)");
            int cvv = CardPayment.nextInt();

            processCardPayment(cardNumber, expiryDate, cvv);

        }


    private void makePizza() {
        System.out.println("Your pizza is making!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        
        System.out.println("Pizza is ready for pickup!");
    }}

    private void printReceipt() {
        System.out.println("*******RECEIPPT**********");
        System.out.println("Order ID: " + orderID);
        System.out.println("Order detail: " + pizzaIngredients);
        System.out.println("Order Total: " + orderTotal);
    }


    public void processCardPayment(long cardNumber ,String expiryDate,int cvv){

        String cardNumberStr =  Long.toString(cardNumber); 
        int cardLength = cardNumberStr.length(); 
        
        if (cardLength == 14) {
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");                       ;
        }
        
         int firstCardDigit = Integer.parseInt(cardNumberStr.substring(0, 1));
        
        String blacklistedNumber = "12345678910111";
        if(cardNumberStr.equals(blacklistedNumber)){
        System.out.println("”Card is blacklisted. Please use another card");
        }
        
        int lastFourDigits = Integer.parseInt(cardNumberStr.substring(11, 14));
        
        String cardNumberToDisplay = firstCardDigit + "*********" + lastFourDigits;
       
        System.out.println("displayable cardNumber:"+cardNumberToDisplay);
        
         }
            
            public void specialOfTheDay(String pizzaOfTheDay,String sideOfTheDay,String specialPrice){
                StringBuilder sb = new StringBuilder();
                sb.append("Today Special:");
                sb.append("Today Pizza:").append(pizzaOfTheDay).append("\n");
                sb.append("Today Side:").append(sideOfTheDay).append("\n");
               sb.append("Today price:").append(specialPrice).append("\n");
               
                System.out.println(sb.toString());
                }
                

} 
