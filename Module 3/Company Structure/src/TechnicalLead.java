import java.util.ArrayList;
import java.util.List;

public class TechnicalLead extends TechnicalEmployee {

    private int headCount;
    private List<SoftwareEngineer> engineerList;

    // Constructor - every technical lead starts with null, has room for 4 engineers
    public TechnicalLead(String name) {
        super(name);
        this.headCount = 4;
        this.engineerList = new ArrayList<SoftwareEngineer>();
    }

    @Override
    public double getBaseSalary() {
        return super.getBaseSalary() * 1.3;
    }

    // checks if tech lead has room on his team
    public boolean hasHeadCount() {
        if (this.engineerList.size() < this.headCount) {
            return true;
        }
        return false;
    }

    // add engineer to the team, set manager for engineer, grants code access
    public boolean addReport(SoftwareEngineer engineer) {
        if (this.hasHeadCount()) {
            this.engineerList.add(engineer);
            engineer.setManager(this);
            engineer.setCodeAccess(true);
            return true;
        }
        return false;
    }

    // returns true if engineer is on a team and has codeaccess
    public boolean approveCheckIn(SoftwareEngineer engineer) {
        if (this.engineerList.contains(engineer)
                &&
                engineer.getCodeAccess()) {
            return true;
        }
        return false;
    }

    // getters and setters
    public List<SoftwareEngineer> getEngineerList() {
        return engineerList;
    }

    public String getTeamStatus() {
        if (this.engineerList.size() == 0) {
            return super.employeeStatus() + "and no direct reports yet";
        }
        String s = super.employeeStatus() + "and is managing:\n";
        s += getTeamStatus_Helper();
        return s;
    }

    private String getTeamStatus_Helper() {
        String s = "";
        for (SoftwareEngineer engineer : engineerList) {
            s += engineer.employeeStatus() + "\n";
        }
        return s;
    }
}
