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
    public static final String BLACKLISTED_NUMBER = "12345678910111";
    
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
    
    double PIZZA_BASE_PRICE = 10.0;
    String[] pizzasOrdered = new String [10];
    String[] pizzaSizesOrdered = new String[10];
    String[] sideDishesOrdered = new String[20];
    String[] drinksOrdered = new String[20];

    enum PizzaSelection{
        PEPPERONI("Pepperoni", "Lots of pepperoni and extra cheese", 18),
        HAWAIIAN("Hawaiian", "Pineapple, ham, and extra cheese", 22),
        VEGGIE("Veggie", "Green pepper, onion, tomatoes, mushroom, and black olives", 25),
        BBQ_CHICKEN("BBQ Chicken", "Chicken in BBQ sauce, bacon, onion, green pepper, and cheddar cheese", 35),
        EXTRAVAGANZA("Extravaganza", "Pepperoni, ham, Italian sausage, beef, onions, green pepper, mushrooms, black olives, and extra cheese", 45);

        private final String pizzaName;
        private final String pizzaToppings;
        private final int price;

        PizzaSelection(String pizzaName, String pizzaToppings, int price) {
            this.pizzaName = pizzaName;
            this.pizzaToppings = pizzaToppings;
            this.price = price;
        }

            public String getPizzaName() {
                return pizzaName;
            }
    
            public String getPizzaToppings() {
                return pizzaToppings;
            }
        
            public int getPrice() {
                return price;
            }
            @Override
            public String toString() {
            return  "pizzaName=" + pizzaName + ", pizzaToppings=" + pizzaToppings + ", price=" + price;
                        }}
                        
    enum PizzaToppings{
            HAM("Ham", 2), 
            PEPPERONI("Pepperoni", 2),
            BEEF("Beef", 2),
            CHICKEN("Chicken", 2), 
            SAUSAGE("Sausage", 2),
            PINEAPPLE("Pineapple", 1),
            ONION("Onion", 0.5), 
            TOMATOES("Tomatoes", 0.4), 
            GREEN_PEPPER("Green Pepper", 0.5), 
            BLACK_OLIVES("Black Olives", 0.5), 
            SPINACH("Spinach", 0.5), 
            CHEDDAR_CHEESE("Cheddar Cheese", 0.8), 
            MOZZARELLA_CHEESE("Mozzarella Cheese", 0.8), 
            FETA_CHEESE("Feta Cheese", 1), 
            PARMESAN_CHEESE("Parmesan Cheese", 1);

    private final String topping;
    private final String toppingPrice;
    
    ToppingSelection(String topping, String toppingPrice) {
        this.topping = topping;
        this.toppingPrice = toppingPrice;
    }    
    
        public String gettopping() {
            return topping;
        }

        public String gettoppingPrice() {
            return toppingPrice;
        }
        @Override
        public String toString() {
        return "topping='" + topping + ", pizzaToppings=" + pizzaToppings;
                    }
    
    }
    enum PizzaSize{
        LARGE("Large", 10), 
        MEDIUM("Medium", 5),
        SMALL("Small", 0);

            private final int pizzaSize;
            private final double addToPizzaPrice;

            SizeSelection(int pizzaSize,double addToPizzaPrice) {
                this.pizzaSize = pizzaSize;
                this.addToPizzaPrice = addToPizzaPrice;
            }  
            @Override
            public String toString() {
            return "pizzaSize='" + pizzaSize + ", addToPizzaPrice=" + addToPizzaPrice;
                        }
            }
    enum SideDish{
        CALZONE("Calzone", 15), 
        CHICKEN_PUFF("Chicken Puff", 20),
        MUFFIN("Muffin", 12),
        NOTHING("No side dish", 0);

        private final String sideDishName;
        private final double addToPizzaPrice;

        ToppingSelection(String sideDishName, double addToPizzaPrice) {
            this.sideDishName = sideDishName;
            this.addToPizzaPrice = addToPizzaPrice;
        }    
        
            public String getsideDishName() {
                return sideDishName;
            }

            public String getaddToPizzaPrice() {
                return addToPizzaPrice;
            }
            @Override
            public String toString() {
            return "sideDishName='" + sideDishName + ", addToPizzaPrice=" + addToPizzaPrice;
                        }
        }
    enum Drinks{
    COCA_COLA("Coca Cola", 8), 
    COCOA_DRINK("Cocoa Drink", 10),
    NOTHING("No drinks", 0);

    private final String drinkName;
    private final double addToPizzaPrice;

        ToppingSelection(String drinkName, double addToPizzaPrice) {
            this.drinkName = drinkName;
            this.addToPizzaPrice = addToPizzaPrice;
        }    
        
            public String getdrinkName() {
                return drinkName;
            }

            public String getaddToPizzaPrice() {
                return addToPizzaPrice;
            }
            @Override
            public String toString() {
            return "drinkName='" + drinkName + ", addToPizzaPrice=" + addToPizzaPrice;
                        }
    }

    public void takeOrder(){
        int ingChoice1, ingChoice2, ingChoice3;
        boolean allChoicesValid = true;
        int sizeChoice;
        int sideDishChoice;
        int drinkChoice;
        Scanner input = new Scanner(System.in);

        System.out.println(" Welcome to Slice-o-Heaven Pizzeria. Here's what we serve:");
        
        int count = 1;
        for (PizzaSelection pizza : PizzaSelection.values()) {
            System.out.println(count + ". " + pizza);
            count++;
        }
        System.out.println(count + ". Custom Pizza with a maximum of 10 toppings that you choose");
        System.out.println("Please enter your choice (1 - \" + count + \"):");
        scanner.nextLine();
        int userChoice;
        String[] pizzasOrdered = new String[1];
        double totalOrderPrice = 0;
        int orderIndex = 0;

        do{
            userChoice = scanner.nextInt();
            if(userChoice < 1||userChoice > 6){
                System.out.println("Invalid choices. Please pick only from the given list: \n");
            } 
            }while(userChoice < 1||userChoice > 6);

        if(userChoice >= 1 && userChoice <= 5){//选前五个确定的
            userChoice = scanner.nextInt();
            PizzaSelection selectedPizza = PizzaSelection.value()[userChoice - 1];
            pizzasOrdered[0] = selectedPizza.toString();
            totalOrderPrice = selectedPizza.getPrice();
            
        }
        
        if(userChoice == 6){//定制6
            userChoice = scanner.nextInt();
            count = 1;
            System.out.println("Available topping:");
            for(PizzaToppings toppings:PizzaToppings.value()){
                System.out.println(count + ". " + toppings);
                count++;
            }

            System.out.print("Please enter up to 10 toppings (separated by commas): ");
            scanner.nextLine(); // 清空缓冲区
            do{
                
                String[] chosenToppings = input.split(",");
                if(ingChoice1 < 1||ingChoice1 > 6){
                    System.out.println("Invalid choices. Please pick only from the given list: \n");
                } 
                }while(ingChoice1 < 1||ingChoice1 > 6);
            
            String[] chosenToppings = input.split(",");

            double customPrice = PIZZA_BASE_PRICE;
            StringBuilder customDescription = new StringBuilder("Custom Pizza with ");
         

            for (String toppingName : chosenToppings) {
                toppingName = toppingName.trim();
                for (PizzaToppings topping : PizzaToppings.values()) {
                    if (topping.getTopping().equals(toppingName)) {
                        customPrice += topping.getPrice();
                        customDescription.append(topping.getTopping()).append(", ");
                    }
                }
            }
            scanner.nextLine();
    
            System.out.print("Pizzas ordered: ");
            for (int i = 0; i < orderIndex; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(pizzasOrdered[i]);
            }
            System.out.println();
        }
        
                // 输出总订单价格
                System.out.println("Total order price: €" + totalOrderPrice);
            orderIndex = 0;
            count = 1;
            System.out.println("Available size:");
            for(PizzaSize size:PizzaSize.value()){
                System.out.println(count + ". " + size);
                count++;
            }

            System.out.print("What size should your pizza be? ");
            scanner.nextLine(); // 清空缓冲区
            do{
                sizeChoice = scanner.nextInt();
                if( sizeChoice < 1|| sizeChoice > 3){
                    System.out.println("Invalid choices. Please pick only from the given list: \n");
                } 
                }while( sizeChoice < 1|| sizeChoice > 3);

        if( sizeChoice >= 1 &&  sizeChoice <= PizzaSize.values().length){
            PizzaSize selectedSize = PizzaSize.values()[ingChoice2- 1];
            pizzaSizesOrdered[orderIndex] = selectedSize.getPizzaName() + ": €" + selectedSize.getPrice();
            totalOrderPrice += selectedSize.getPrice();
            orderIndex++;
        }//如果有效相加

        String pizzaSize = convertSideChoice(sizeChoice);
        totalOrderPrice += PizzaSize.getPrice();
       
        
        System.out.println("Do you want extra cheese (Y/N):");
        String extraCheese = input.nextLine();


        orderIndex = 0;
            count = 1;
            System.out.println("Available side dish:");
            for(SideDish dish:SideDish.value()){
                System.out.println(count + ". " + dish);
                count++;
            }

            System.out.print("What side dish should your pizza be? ");
            scanner.nextLine(); // 清空缓冲区
            do{
                sideDishChoice = scanner.nextInt();
                if(sideDishChoice < 1||sideDishChoice > 4){
                    System.out.println("Invalid choices. Please pick only from the given list: \n");
                } 
                }while(sideDishChoice < 1||sideDishChoice > 4);

        if(sideDishChoice >= 1 && sideDishChoice <= SideDish.values().length){
            SideDish selectedDish = SideDish.values()[ingChoice2- 1];
            pizzaSizesOrdered[orderIndex] = selectedSize.getPizzaName() + ": €" + selectedSize.getPrice();
            totalOrderPrice += selectedDish.getPrice();
            orderIndex++;
        }//如果有效相加
;
        
       

        do{
            System.out.println("Choose from one of the drinks below. We recommend Coca Cola:\r\n" + //
                                " 1. Coca Cola\r\n" + //
                                " 2. Cold coffee\r\n" + //
                                " 3. Cocoa Drink\r\n" + //
                                " 4. No drinks for me\r\n" + //
                                " Enter your choice:");
            drinkChoice = input.nextInt();
            input.nextLine();
            if (!isValidChoice3(drinkChoice)) {
                System.out.println("Invalid choice(s). Please pick only from the given list:");
                allChoicesValid = false;
            }
        }
            while(!allChoicesValid);
            String drinks = convertSize(drinkChoice);
            
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
        @Override
        public String toString() {
            StringBuilder orderDetails = new StringBuilder("Thank you for dining with Slice-o-Heaven Pizzeria. Your order details are as follows:\n");
            for (int i = 0; i < pizzaOrderIndex; i++) {
                orderDetails.append((i + 1)).append(". ").append(pizzasOrdered[i]).append("\n");
                if (i < sizeOrderIndex) {
                    orderDetails.append("   ").append(pizzaSizesOrdered[i]).append("\n");
                }
                if (i < sideDishOrderIndex) {
                    orderDetails.append("   ").append(sideDishesOrdered[i]).append("\n");
                }
                if (i < drinkOrderIndex) {
                    orderDetails.append("   ").append(drinksOrdered[i]).append("\n");
                }
                orderDetails.append("\n");
            }
            orderDetails.append("ORDER TOTAL: €").append(totalOrderPrice);
            return orderDetails.toString();
        }
   

    
   

        public void isItYourBirthday() {
            Scanner yourbirthday = new Scanner(System.in);
            LocalDate dob = null;
    
            while (true) {
                System.out.println("Please enter your birthday (in the format yyyy-mm-dd):");
                String birthdateStr = yourbirthday.nextLine();
                    String years = birthdateStr.substring(0, 4);
                    String months = birthdateStr.substring(5, 7);
                    String days = birthdateStr.substring(8, 10);
    
                    int year = Integer.parseInt(years);
                    int month = Integer.parseInt(months);
                    int day = Integer.parseInt(days);
    
                    dob = LocalDate.of(year, month, day);
                    LocalDate now = LocalDate.now();
                    Period period = Period.between(dob, now);
                    int age = period.getYears();
    
                    if (age < 5 || age > 120) {
                        System.out.println("Invalid date. You are either too young or too dead to order. " +
                                "Please enter a valid date:");
                    } else {
                        break;
                    }
                } 
                    System.out.println("Invalid date format. Please enter the date in the format yyyy-mm-dd.");
                
            
    
            LocalDate now = LocalDate.now();
            Period period = Period.between(dob, now);
            int age = period.getYears();
    
            if (age < 18 && dob.getDayOfYear() == now.getDayOfYear()) {
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
            CardPayment.close();

        }


    private void makePizza() {
        System.out.println("Your pizza is making!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        
        System.out.println("Pizza is ready for pickup!");
    }}


    private void processCardPayment(long cardNumber, String expiryDate, int cvv){
    
            Scanner scanner = new Scanner(System.in);
            String cardNumberStr;
    
            while (true) {
                System.out.println("Please enter your 14 - digit card number:");
                if (scanner.hasNextLong()) {
                    cardNumber = scanner.nextLong();
                    cardNumberStr = Long.toString(cardNumber);
                }
    
                    
                    if (cardNumberStr.length() == 14 &&!cardNumberStr.equals(BLACKLISTED_NUMBER)) {
                        break;
                    } else {
                        if (cardNumberStr.length() != 14) {
                            System.out.println("Invalid card number length. The card number must be 14 digits long.");
                        }
                        if (cardNumberStr.equals(BLACKLISTED_NUMBER)) {
                            System.out.println("Card is blacklisted. Please use another card.");
                        }
                    }
                 else{
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine(); 
                }
            }
    
            
            System.out.println("Please enter the card's expiry date (MM/YY):");
            expiryDate = scanner.next();
    
            System.out.println("Please enter the CVV:");
            cvv = scanner.nextInt();
    
            
            int firstCardDigit = Integer.parseInt(cardNumberStr.substring(0, 1));
            
            int lastFourDigits = Integer.parseInt(cardNumberStr.substring(10, 14));
    
            
            String cardNumberToDisplay = firstCardDigit + "*********" + lastFourDigits;
            System.out.println("Displayable card number: " + cardNumberToDisplay);
            System.out.println("Card accepted");
    
            
            System.out.println("Expiry Date: " + expiryDate);
            System.out.println("CVV: " + cvv);
    
            scanner.close();
    }
    
            
            public void specialOfTheDay(String pizzaOfTheDay,String sideOfTheDay,String specialPrice){
                StringBuilder sb = new StringBuilder();
                sb.append("Today Special:");
                sb.append("Today Pizza:").append(pizzaOfTheDay).append("\n");
                sb.append("Today Side:").append(sideOfTheDay).append("\n");
               sb.append("Today price:").append(specialPrice).append("\n");
               
                System.out.println(sb.toString());
                }

            
        
         @Override
          public String toString() {
                    StringBuilder receipt = new StringBuilder();
                    receipt.append("*******RECEIPPT**********\n");
                    receipt.append("Order ID: ").append(orderID).append("\n");
                    receipt.append("Order detail: ").append(pizzaIngredients).append("\n");
                    receipt.append("Order Total: ").append(orderTotal);
                    return receipt.toString();
                }
            }  










            enum PizzaSizes {
                Small, Medium, Large
            }
            
            // 定义配菜枚举
            enum SideDish {
                Calzone, Chicken_puff, Garlic_bread
            }
            
            // 定义饮品枚举
            enum Drinks {
                Coca_cola, Cocoa_drink, No_drinks
            }
            
            // 订单类
            class Order {
                private String pizza;
                private PizzaSizes size;
                private SideDish sideDish;
                private Drinks drink;
                private double price;
            
                public Order(String pizza, PizzaSizes size, SideDish sideDish, Drinks drink) {
                    this.pizza = pizza;
                    this.size = size;
                    this.sideDish = sideDish;
                    this.drink = drink;
                    calculatePrice();
                }
            
                // 根据选择计算订单价格
                private void calculatePrice() {
                    double pizzaPrice = 0;
                    double sizePrice = 0;
                    double sideDishPrice = 0;
                    double drinkPrice = 0;
            
                    // 假设一些价格
                    if (pizza.equals("Pepperoni Pizza with Lots of pepperoni and extra cheese")) {
                        pizzaPrice = 18;
                    } else if (pizza.equals("Hawaiian Pizza with Pineapple")) {
                        pizzaPrice = 22;
                    } else if (pizza.equals("Custom Pizza with Pepperoni, onion, black olives, and cheddar cheese")) {
                        pizzaPrice = 13.8;
                    }
            
                    if (size == PizzaSizes.Small) {
                        sizePrice = 0;
                    } else if (size == PizzaSizes.Medium) {
                        sizePrice = 5;
                    } else if (size == PizzaSizes.Large) {
                        sizePrice = 10;
                    }
            
                    if (sideDish == SideDish.Calzone) {
                        sideDishPrice = 15;
                    } else if (sideDish == SideDish.Chicken_puff) {
                        sideDishPrice = 20;
                    } else if (sideDish == SideDish.Garlic_bread) {
                        sideDishPrice = 12;
                    }
            
                    if (drink == Drinks.Coca_cola) {
                        drinkPrice = 8;
                    } else if (drink == Drinks.Cocoa_drink) {
                        drinkPrice = 10;
                    } else if (drink == Drinks.No_drinks) {
                        drinkPrice = 0;
                    }
            
                    price = pizzaPrice + sizePrice + sideDishPrice + drinkPrice;
                }
            
                // 获取订单价格
                public double getPrice() {
                    return price;
                }
            
                // 更新toString方法
                @Override
                public String toString() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(pizza).append(": £").append(getPizzaPrice()).append("\n");
                    sb.append(size).append(": £").append(getSizePrice()).append("\n");
                    sb.append(sideDish).append(": £").append(getSideDishPrice()).append("\n");
                    sb.append(drink).append(": £").append(getDrinkPrice()).append("\n");
                    return sb.toString();
                }
            
                // 辅助方法获取各部分价格
                private double getPizzaPrice() {
                    if (pizza.equals("Pepperoni Pizza with Lots of pepperoni and extra cheese")) {
                        return 18;
                    } else if (pizza.equals("Hawaiian Pizza with Pineapple")) {
                        return 22;
                    } else if (pizza.equals("Custom Pizza with Pepperoni, onion, black olives, and cheddar cheese")) {
                        return 13.8;
                    }
                    return 0;
                }
            
                private double getSizePrice() {
                    if (size == PizzaSizes.Small) {
                        return 0;
                    } else if (size == PizzaSizes.Medium) {
                        return 5;
                    } else if (size == PizzaSizes.Large) {
                        return 10;
                    }
                    return 0;
                }
            
                private double getSideDishPrice() {
                    if (sideDish == SideDish.Calzone) {
                        return 15;
                    } else if (sideDish == SideDish.Chicken_puff) {
                        return 20;
                    } else if (sideDish == SideDish.Garlic_bread) {
                        return 12;
                    }
                    return 0;
                }
            
                private double getDrinkPrice() {
                    if (drink == Drinks.Coca_cola) {
                        return 8;
                    } else if (drink == Drinks.Cocoa_drink) {
                        return 10;
                    } else if (drink == Drinks.No_drinks) {
                        return 0;
                    }
                    return 0;
                }
            }
            
            public class PizzaOrderSystem {
                public static void main(String[] args) {
                    Scanner scanner = new Scanner(System.in);
                    double totalOrderPrice = 0;
                    boolean continueOrdering = true;
            
                    while (continueOrdering) {
                        System.out.println("Please choose a pizza:");
                        System.out.println("1. Pepperoni Pizza with Lots of pepperoni and extra cheese");
                        System.out.println("2. Hawaiian Pizza with Pineapple");
                        System.out.println("3. Custom Pizza with Pepperoni, onion, black olives, and cheddar cheese");
                        int pizzaChoice = scanner.nextInt();
                        String pizza = "";
                        if (pizzaChoice == 1) {
                            pizza = "Pepperoni Pizza with Lots of pepperoni and extra cheese";
                        } else if (pizzaChoice == 2) {
                            pizza = "Hawaiian Pizza with Pineapple";
                        } else if (pizzaChoice == 3) {
                            pizza = "Custom Pizza with Pepperoni, onion, black olives, and cheddar cheese";
                        }
            
                        System.out.println("Please choose a size:");
                        for (PizzaSizes size : PizzaSizes.values()) {
                            System.out.println(size.ordinal() + 1 + ". " + size);
                        }
                        int sizeChoice = scanner.nextInt();
                        PizzaSizes size = PizzaSizes.values()[sizeChoice - 1];
            
                        System.out.println("Please choose a side dish:");
                        for (SideDish sideDish : SideDish.values()) {
                            System.out.println(sideDish.ordinal() + 1 + ". " + sideDish);
                        }
                        int sideDishChoice = scanner.nextInt();
                        SideDish sideDish = SideDish.values()[sideDishChoice - 1];
            
                        System.out.println("Please choose a drink:");
                        for (Drinks drink : Drinks.values()) {
                            System.out.println(drink.ordinal() + 1 + ". " + drink);
                        }
                        int drinkChoice = scanner.nextInt();
                        Drinks drink = Drinks.values()[drinkChoice - 1];
            
                        Order order = new Order(pizza, size, sideDish, drink);
                        totalOrderPrice += order.getPrice();
            
                        System.out.println("Current order details:\n" + order);
            
                        System.out.println("Do you want to order more? (1 for yes, 0 for no)");
                        int choice = scanner.nextInt();
                        if (choice == 0) {
                            continueOrdering = false;
                        }
                    }
            
                    System.out.println("Thank you for dining with Slice - o - Heaven Pizzeria. Your order details are as follows:");
                    System.out.println("ORDER TOTAL: £" + totalOrderPrice);
            
                    scanner.close();
                }
            }


