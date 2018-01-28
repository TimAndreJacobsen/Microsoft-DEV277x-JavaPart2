public class SoftwareEngineer extends TechnicalEmployee {

    private boolean codeAccess;
    private int checkIns;
    private TechnicalLead manager;

    public SoftwareEngineer(String name) {
        super(name);
        this.codeAccess = false;
    }

    // getters and setters
    public void setManager(TechnicalLead manager) {
        this.manager = manager;
    }

    @Override
    public TechnicalLead getManager() {
        return manager;
    }

    @Override
    public int getCheckIns() {
        return checkIns;
    }

    public boolean getCodeAccess() {
        return codeAccess;
    }

    public void setCodeAccess(boolean access) {
        this.codeAccess = access;
    }

    // class methods
    public boolean checkInCode() {
        if (this.manager.approveCheckIn(this)) {
            this.checkIns++;
            return true;
        }
        setCodeAccess(false);
        return false;
    }
}
