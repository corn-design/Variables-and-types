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
        int ingChoice1, ingChoice2, ingChoice3;
        boolean allChoicesValid;
        int sizeChoice;
        int sideDishChoice;
        Scanner input = new Scanner(System.in);
        
        do{
            System.out.println("Please pick any three of the following ingredients:\r\n" + //
                        " 1. Mushroom\r\n" + //
                        " 2. Paprika\r\n" + //
                        " 3. Sun-dried tomatoes\r\n" + //
                        " 4. Chicken\r\n" + //
                        " 5. Pineapple\r\n" + //
                        " Enter any three choices (1, 2, 3,…) separated by spaces:");
        ingChoice1 = input.nextInt();
        ingChoice2 = input.nextInt();
        ingChoice3 = input.nextInt(); 
        if (!isValidChoice(ingChoice1)) {
            allChoicesValid = false;
        }
        if (!isValidChoice(ingChoice2)) {
            allChoicesValid = false;
        }
        if (!isValidChoice(ingChoice3)) {
            allChoicesValid = false;
        }

        if (!allChoicesValid) {
            System.out.println("Invalid choice(s). Please pick only from the given list:");
        } 
        }
        while(allChoicesValid);
            String ing1 = convertChoice(ingChoice1);
            String ing2 = convertChoice(ingChoice2);
            String ing3 = convertChoice(ingChoice3);
            System.out.println("You have chosen: " + ing1 + ", " + ing2 + ", " + ing3);
         
        do{
        System.out.println("What size should your pizza be?\r\n" + //
                        " 1. Large\r\n" + //
                        " 2. Medium\r\n" + //
                        " 3. Small\r\n" + //
                        " Enter only one choice (1, 2, or 3):");
        sizeChoice = input.nextInt();
         if (!isValidChoice2(sizeChoice)) {
            System.out.println("Invalid choice(s). Please pick only from the given list:");
            allChoicesValid = false;
        }
        while(allChoicesValid);
        String pizzaSize = convertSideChoice(sizeChoice);
       
        
        System.out.println("Do you want extra cheese (Y/N):");
        String extraCheese = input.nextLine();
        
        do{
        System.out.println("Following are the side dish that go well with your pizza:\r\n" + //
                        " 1. Calzone\r\n" + //
                        " 2. Garlic bread\r\n" + //
                        " 3. Chicken puff\r\n" + //
                        " 4. Muffin\r\n" + //
                        " 5. Nothing for me\r\n" + //
                        " What would you like? Pick one (1, 2, 3,…):");
        sideDishChoice = input.nextInt();
        if (!isValidChoice(sideDishChoice)) {
            System.out.println("Invalid choice(s). Please pick only from the given list:");
            allChoicesValid = false;
        }
        while(allChoicesValid);
        String sideDish = convertSize(sideDishChoice);

        do{
            System.out.println("Choose from one of the drinks below. We recommend Coca Cola:\r\n" + //
                                " 1. Coca Cola\r\n" + //
                                " 2. Cold coffee\r\n" + //
                                " 3. Cocoa Drink\r\n" + //
                                " 4. No drinks for me\r\n" + //
                                " Enter your choice:");

       

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
    
    private static boolean isValidChoice(int choice) {
        return choice >= 1 && choice <= 5;
    }
    private static boolean isValidChoice2(int choice) {
        return choice >= 1 && choice <= 3;
    }
    private static String convertChoice(int choice) {
        switch (choice) {
        case 1:
            return "Mushroom";
        case 2:
            return "Paprika";
        case 3:
            return "Sun - dried tomatoes";
        case 4:
            return "Chicken";
        case 5:
            return "Pineapple";
        default:
            return"";
        }   
       }
       private static String convertSize(int choice) {
        switch (choice) {
        case 1:
            return "Large";
        case 2:
            return "Medium";
        case 3:
            return "Small";
     
        }   
    }
    private static String convertSideChoice(int choice) {
        switch (choice) {
        case 1:
            return "Calzone";
        case 2:
            return " Garlic bread";
        case 3:
            return "Chicken puff";
        case 4:
            return "Muffin";
        case 5:
            return "Nothing for me";
        }   
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
