public class MinMaxAccount extends BankingAccount {

    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) {
        super(s);
        this.maxBalance=s.startup_getBalance();
        this.minBalance=s.startup_getBalance();
    }

    // 	returns minimum balance in pennies
    public int getMin() {
        return minBalance;
    }

    // 	returns maximum balance in pennies
    public int getMax() {
        return maxBalance;
    }

    public void debit(Debit d) {
        super.debit(d);

        if (getBalance()>maxBalance){
            maxBalance=getBalance();
        }
        if (getBalance()<minBalance){
            minBalance=getBalance();
        }
    }

    public void credit(Credit c){
        super.credit(c);

        if (getBalance()>maxBalance){
            maxBalance=getBalance();
        }
        if (getBalance()<minBalance){
            minBalance=getBalance();
        }
    }

    public int getBalance() {
        return super.getBalance();
    }

}