/**
 * Created by Pin on 10-Oct-16.
 * Problem Wk.5.1.4: Recursive Factorial
 */
public class MCN {
    public static long mcn(int m, int n) {
        long denominator = factorial(n)*factorial(m-n);
        long numerator = factorial(m);
        return numerator/denominator;
    }
    public static long factorial(int x){
        long fact = 1;
        for (int i = 1; i <= x; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static void main(String[] args) {
        System.out.println(mcn(4,1));
        System.out.println(mcn(6,2));
        System.out.println(mcn(8,5));
        System.out.println(mcn(12,8));
    }
}
