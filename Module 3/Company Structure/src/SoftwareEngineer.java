public class SoftwareEngineer extends TechnicalEmployee {

    private boolean codeAccess;
    private int checkIns;
    private TechnicalLead manager;

    public SoftwareEngineer(String name) {
        super(name);
        this.codeAccess = false;
    }

    public void setManager(TechnicalLead manager) {
        this.manager = manager;
    }

    public int getCheckIns() {
        return checkIns;
    }

    public boolean getCodeAccess() {
        return codeAccess;
    }

    public void setCodeAccess(boolean access) {
        this.codeAccess = access;
    }

    public boolean checkInCode() {
        if (this.manager.approveCheckIn(this)) {
            this.checkIns++;
            return true;
        }
        setCodeAccess(false);
        return false;
    }
}
