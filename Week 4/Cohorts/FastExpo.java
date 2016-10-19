/**
 * Created by Pin on 06-Oct-16.
 * Recursion: a to the power of k
 */
public class FastExpo {
    public static void main(String[] args) {
        int a = 3;
        int k = 10;
        System.out.println(fexp(a, k));
    }

    // find a to power of k
    public static int fexp(int a, int k){
        if (k==1) return a;
        if (k%2==0){ // for even cases
            return fexp(a, k/2) * fexp(a, k/2);
        }
        else{ // for odd cases
            return a * fexp(a, k/2) * fexp(a, k/2);
        }
    }
}
