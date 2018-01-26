public class DiscountBill extends GroceryBill {

    private Boolean preferred;
    private int discountCount;
    private double discountAmount;


    public DiscountBill(Employee clerk, Boolean preferred) {
        super(clerk);
        this.preferred = preferred;
        this.discountCount = 0;
    }

    @Override
    public void add(Item i) {
        super.add(i);
        if (preferred && i.getDiscount()>0) {
            discountAmount += i.getDiscount();
            discountCount++;
        }
    }

    public int getDiscountCount() {
        return discountCount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getDiscountPercent() {
        return (discountAmount*100) / super.getTotal();
    }

    public double getTotal() {
        if (preferred) {
            return super.getTotal() - discountAmount;
        }
            return super.getTotal();
    }

}
