import java.util.ArrayList;
import java.util.List;

public class BusinessLead extends BusinessEmployee {

    private int headCount;
    private List<Accountant> accountantsTeam;
    private double budget;

    public BusinessLead(String name) {
        super(name);
        double salary = getBaseSalary() * 2.0;
        this.setBaseSalary(salary);
        this.headCount = 10;
        this.accountantsTeam = new ArrayList<Accountant>();
        this.budget = 0;
    }

    // getters and setters
    public double getBudget() {
        return this.budget;
    }

    public void deductBudget(double bonus) {
        this.budget -= budget;
    }

    // class methods
    public boolean addReport(Accountant accountant, TechnicalLead supportTeam) {

        if (hasHeadCount()) {
            this.accountantsTeam.add(accountant);
            accountant.setManager(this);
            accountant.setSupportsTechLead(supportTeam);
            this.budget += Math.round(accountant.getBaseSalary() * 1.1);
            return true;
        }
        return false;
    }

    public boolean requestBonus(Employee e, double bonus) {
        if (bonus <= getBudget()) {
            this.deductBudget(bonus);
            e.giveBonus(bonus); // ???? move to approve?
            return true;
        }
        return false;
    }

    public boolean approveBonus(Employee e, double bonus) {
        TechnicalLead techLead = (TechnicalLead)e.getManager(); // should return this employees techLead
        if (techLead.getAccountant().getBonusBudget() >= bonus) {
            techLead.getAccountant().deductBonusBudget(bonus);
            e.giveBonus(bonus);
            return true;
        }
        return false;
    }

    // helper method - checks if Business Lead has room on team.
    public boolean hasHeadCount() {
        if (this.accountantsTeam.size() < this.headCount) {
            return true;
        }
        return false;
    }

    public String getTeamStatus() {
        if (this.accountantsTeam.size() == 0) {
            return super.employeeStatus() + "and no direct reports yet";
        }
        String s = super.employeeStatus() + "and is managing:\n";
        s += getTeamStatus_Helper();
        return s;
    }

    private String getTeamStatus_Helper() {
        String s = "";
        for (Accountant accountant : accountantsTeam) {
            s += accountant.employeeStatus() + "\n";
        }
        return s;
    }
}
