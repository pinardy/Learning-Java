/**
 * Created by Pin on 04-Oct-16.
 */
public class ifact {
    public static void main(String[] args) {
//        System.out.println(ifact(4));
        System.out.println(rfact(4));
    }
    // Iterative: (Non recursive)
    public static int ifact(int k){
        int result = 1;
        for (int i=1; i<=k; i++){
            result = result*i;
        }
        return result;
    }
    // Recursive
    public static int rfact(int k){
//        return k * rfact(k-1); // Cannot put this alone as program will not stop
//        Hence we need a base case.
        System.out.println("in rfact");
        if (k==0) return 1; // the base case
        else{
            int temp = k * rfact(k-1);
            System.out.println("k, temp = " + k + " " + temp);
            return k * rfact(k-1);
        }
    }
}
