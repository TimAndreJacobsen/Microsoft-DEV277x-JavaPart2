public abstract class TechnicalEmployee extends Employee {

    private int checkIns;

    public TechnicalEmployee(String name) {
        super(name, 75000);
        this.checkIns = 0;
    }

    @Override
    public String employeeStatus(){
        this.checkIns = this.getCheckIns();
        if (this.checkIns > 0) {
            return super.employeeStatus() + "has " + checkIns + " successful check ins ";
        }
        return super.employeeStatus() + "has no check ins ";
    }

    public int getCheckIns() {
        return checkIns;
    }

}
