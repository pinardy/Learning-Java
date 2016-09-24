/**
 * Created by Pin on 20-Sep-16.
 */
public class TestCheckingAccount {
    public static void main(String[] args) {

        CheckingAccount myCheckAcc = new CheckingAccount(1024, 8000.0);
        myCheckAcc.deposit(2000);
        myCheckAcc.withdraw(15000);

        System.out.println(myCheckAcc.getBalance());
        myCheckAcc.withdraw(200);
        System.out.println(myCheckAcc.getBalance());
        myCheckAcc.deposit(7000);
        myCheckAcc.withdraw(200);
        System.out.println(myCheckAcc.getBalance());
    }
}

//  -----Output------
//        -5000.0
//        over limit
//        -5000.0
//        1800.0