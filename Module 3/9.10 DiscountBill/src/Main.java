public class Main {

    public static void main(String[] args) {

        GroceryBill.Employee james = new GroceryBill.Employee("james");

        DiscountBill dBill = new DiscountBill(james, true);
        DiscountBill dBillFalse = new DiscountBill(james, false);

        GroceryBill.Item candyBar = new GroceryBill.Item("candy bar", 1.35, 0.25);
        GroceryBill.Item toyCar = new GroceryBill.Item("Toy car", 3.25, 0.5);
        GroceryBill.Item apple = new GroceryBill.Item("crackers", 0.30, 0.05);
        GroceryBill.Item orange = new GroceryBill.Item("orange", 0.30, 0.05);
        GroceryBill.Item newspaper = new GroceryBill.Item("Newspaper", 0.99, 0.0);

        dBill.add(candyBar);
        dBill.add(toyCar);
        dBill.add(apple);
        dBill.add(orange);
        dBill.add(newspaper);


        System.out.println("getTotal: " +
                dBill.getTotal() + "\nAmount: " +
                dBill.getDiscountAmount() + " \nCount: " +
                dBill.getDiscountCount() + " \n%:" +
                dBill.getDiscountPercent());

        dBillFalse.add(candyBar);
        dBillFalse.add(toyCar);
        dBillFalse.add(apple);
        dBillFalse.add(orange);
        dBillFalse.add(newspaper);

    }
}
