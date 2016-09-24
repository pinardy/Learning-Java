/**
 * Created by Pin on 20-Sep-16.
 * Problem Wk.2.5.3: Subclassess of Account
 */
public class CheckingAccount extends Account {
    //data
    private float overDraft = -5000;

    // ------ Constructors ------ //
    public CheckingAccount(){
    }

    public CheckingAccount(int id, double balance) {
        super(id, balance);
    }

    @Override
    public void withdraw(double amount) {
        double newBalance = getBalance() - amount;
        if (newBalance < overDraft) {
            System.out.println("over limit");
            setBalance(newBalance + amount);
        } else {
            setBalance(newBalance);
        }
    }
}
