/**
 * Created by Pin on 17-Sep-16.
 * Problem Wk.1.5.3: Prime Number Checker
 */
/* For this problem, I referred to https://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
   This page compares between different ways of solving the same problem in terms of algorithm speed.
 */
public class PrimeNumberChecker{
    public static int isPrime(int num) {
        if (num % 2 == 0) {
            return 0;
        }
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(7));
    }
}
