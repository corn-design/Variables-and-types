public class Main {
    public static void main(String[] args) {
    
        SliceOHeaven order1 = new SliceOHeaven();
        order1.generateReceipt();

        System.out.println();

    
        SliceOHeaven order2 = new SliceOHeaven("SOH-123", "Pepperoni, Mushrooms", 20.00);
        order2.setSides("Garlic Bread");
        order2.setDrinks("Coke");
        order2.generateReceipt();
    }
}

