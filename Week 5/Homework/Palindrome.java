/**
 * Created by Pin on 12-Oct-16.
 * Problem Wk.5.5.5: Palindrome
 */
import java.util.Arrays;

public class Palindrome {
    public static boolean isPalindrome (char[] S) {
        // base cases
        if (S.length == 1) return true;
        else if (S == null || S.length == 0) {
            return false;
        } else if (S.length == 2) {
            return S[0] == S[1];
        } else {
            int len = S.length;
            // Compare the first and last element
            if (S[0] != S[len - 1]) {
                return false;
            }
            // Recursively call (Remove first and last char of array)
            return isPalindrome(Arrays.copyOfRange(S, 1, len - 1));
        }
    }

    public static void main(String[] args) {
        char[] S = {'d','b','b','a'};
        if(isPalindrome(S)) {
            System.out.println(S + " is a palindrome");
        } else
            System.out.println(S + " is not a palindrome");
    }
}