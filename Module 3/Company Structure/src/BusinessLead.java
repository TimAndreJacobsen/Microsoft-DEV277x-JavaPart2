import java.util.ArrayList;
import java.util.List;

public class BusinessLead extends BusinessEmployee {

    private double salary;
    private int headCount;
    private List<Accountant> accountantsTeam;

    public BusinessLead(String name) {
        super(name);
        double salary = getBaseSalary() * 2.0;
        this.setBaseSalary(salary);
        this.headCount = 10;
        this.accountantsTeam = new ArrayList<Accountant>();
    }


}
