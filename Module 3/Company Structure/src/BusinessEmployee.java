public abstract class BusinessEmployee extends Employee{

    private double bonusBudget;
    private Accountant acc;

    public BusinessEmployee(String name) {
        super(name, 50000);
    }

    public double getBonusBudget() {
        return acc.getBonusBudget();
    }

    @Override
    public String employeeStatus() {
        return super.employeeStatus() + "with a budget of " + getBonusBudget();
    }
}
