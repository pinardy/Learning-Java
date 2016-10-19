/**
 * Created by Pin on 18-Oct-16.
 */
public class Palindrome {
    public static boolean recurPalindrome (String strSubmitted) {
        // base cases
        // For null input & empty input
        if (strSubmitted.length() == 1 || strSubmitted.length() == 0) {
            return true;
        }
        if (strSubmitted.length() == 2) {
            return (strSubmitted.charAt(0) == strSubmitted.charAt(strSubmitted.length()-1));
        }
        // Smaller subproblems
        else {
            int length = strSubmitted.length();
//            System.out.println(length);
            // Compare first and last element
            char[] arrayOfChars = strSubmitted.toCharArray();
            if (arrayOfChars[0] != arrayOfChars[length-1]){
                return false;
            }
            // Recursively call (Remove first and last char of array)
            return recurPalindrome(strSubmitted.substring(1, length-1));
        }
    }

    public static void main(String[] args) {
        String[] wordlist = { "civic", "Singapore", "deified", "Technology", "Design" };
        for (int i = 0; i < wordlist.length; i++) {
            System.out.println("RecurPalinCheck: "+ Palindrome.recurPalindrome(wordlist[i]));
        }
    }
}

/*  Test Cases -----------
        RecurPalinCheck: true
        RecurPalinCheck: false
        RecurPalinCheck: true
        RecurPalinCheck: false
        RecurPalinCheck: false
*/
