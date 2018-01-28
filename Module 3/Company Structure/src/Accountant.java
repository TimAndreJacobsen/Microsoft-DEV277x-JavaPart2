public class Accountant extends BusinessEmployee {

    private TechnicalLead supportsTechLead;
    private BusinessLead businessLead;
    private double bonusBudget;

    public Accountant(String name) {
        super(name);
        this.supportsTechLead = null;
        this.bonusBudget = 0;
        System.out.println("salary set to: " + this.getBaseSalary());
    }

    @Override
    public double getBonusBudget() {
        return bonusBudget;
    }
    @Override
    public String employeeStatus() {
        return super.employeeStatus() + " is supporting " + getTechLead();
    }

    // getters and setters
    public TechnicalLead getTechLead() {
        return this.supportsTechLead;
    }

    public void setSupportsTechLead(TechnicalLead setTechlead) {
        if (setTechlead == null) {
            System.out.println("You passed null as tech lead");
            return;
        }
        this.supportsTechLead = setTechlead;
        this.bonusBudget = calculateBonus(setTechlead);
        System.out.println("bonus budget calculated: " + bonusBudget);
        setTechlead.setAccountant(this);
    }

    public void setManager(BusinessLead businessLead) {
        this.businessLead = businessLead;
    }

    @Override
    public BusinessLead getManager() {
        return this.businessLead;
    }

    // helper method  returns 75 000 * team.size OR 0 if no team/empty budget
    private double calculateBonus(TechnicalLead techLead) {
        double bonusDraft = Math.round(((double)techLead.getEngineerList().size() * 75000.0 ) * 1.1);
        if (approveBonus(bonusDraft))
            return bonusDraft;
        return 0;
    }

    // helper method  Checks if budget > calculated bonus
    public boolean approveBonus(double bonusDraft) {
        if (getManager().getBudget() >= bonusDraft) {
            // Deduct from budget?
            return true;
        }
        return false;
    }

    public void deductBonusBudget(double bonus) {
        this.bonusBudget -= bonus;
    }
}
