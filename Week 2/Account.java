import java.util.Date;

/**
 * Created by Pin on 17-Sep-16.
 */
public class Account {

    private int id = 0;
    private double balance = 0;
    private static double annualInterestRate = 0; // in %
    private Date dateCreated; // Need to create a Date data type

    // ------ Constructors ------ //
    public Account(){
    }

    public Account(int id, double balance){
        this.id = id;
        this.balance = balance;
    }
    //------------------ Getters and setters -------------------//
    public int getID(){
        return id;
    }
    public void setID(int id){   // NOT: public int setID(int id)
        this.id = id;
    }  //---------------------//
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }  //---------------------//
   public double getAnnualInterestRate() {
       return id;
   }
   public void setAnnualInterestRate(double annualInterestRate){
       this.annualInterestRate = annualInterestRate;
   }   //======================================================//
   public Date getDateCreated(){
       return dateCreated;
   }
   public double getMonthlyInterestRate(){
       return annualInterestRate/12.0;
   }
   public double getMonthlyInterest(){
       return getMonthlyInterestRate()*balance/100;
   }
    public void withdraw(double amount){
        balance -= amount;
    }
    public void deposit(double amount){
        balance += amount;
    }
}
