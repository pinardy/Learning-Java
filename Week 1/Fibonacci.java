package Fibonacci;

/**
 * Created by Pin on 16-Sep-16.
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci());
    }

    public static String fibonacci() {
        int n1 = 0, n2 = 1, n3, count = 20;
        String output = String.valueOf(n1 + "," + n2);

        for (int i = 2; i < count; ++i) {
            n3 = n1 + n2;
            // String.valueOf(n3);
            // System.out.print(" "+n3);
            output += "," + String.valueOf(n3);
            n1 = n2;
            n2 = n3;
        }
        return output;
    }
}
