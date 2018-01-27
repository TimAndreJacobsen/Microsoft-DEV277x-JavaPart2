public abstract class Employee {

    private String name;
    private static int employeeInstanceCounter = 0;
    private double salary;
    private int employeeID;
    private TechnicalLead manager;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.salary = baseSalary;

        // Generating incrementing unique ID
        employeeInstanceCounter++;
        this.employeeID = employeeInstanceCounter;
    }

    public double getBaseSalary() {
        return this.salary;
    }

    public void setBaseSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    public Employee getManager() {
        return this.manager;
    }

    public boolean equals(Employee other) {
        // should return true if they are equal, false otherwise
        return (this.employeeID == other.getEmployeeID());
    }

    public String toString() {
        return this.employeeID + " " + this.name;
    }

    public String employeeStatus() {
        return "" + getEmployeeID() + " " + this.getName() + " ";
    }
}
