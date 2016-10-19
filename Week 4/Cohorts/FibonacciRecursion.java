/**
 * Created by Pin on 04-Oct-16.
 */
public class FibonacciRecursion {
    public static void main(String[] args) {
        System.out.println(rfib(3));
    }
    public static int rfib (int k){
        if (k == 0) 	return 0;
        else if (k == 1) return 1;
        else {
            return rfib (k - 1) + rfib (k - 2);
        }
    }

}
