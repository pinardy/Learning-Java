import java.util.Arrays;

/**
 * Created by Pin on 24-Sep-16.
 * Problem Wk.2.5.4: String Operation
 */
public class StringOperation {
    // T(n) = Big Omega (n^2)
    public static boolean isAllCharacterUnique(String sIn) {
        if (sIn.length() > 32768) {
            return false;
        }
        for (char c : sIn.toCharArray()) {
            if (sIn.indexOf(c) != sIn.lastIndexOf(c)) return false;
        }
                return true;
        }

    // T(n) = Big Omega (n^2)
    public static boolean isPermutation(String sIn1, String sIn2){
        if (sIn1.length()!= sIn2.length()) return false;

        char[] string1 = sIn1.toCharArray();
        char[] string2 = sIn2.toCharArray();

        Arrays.sort(string1);
        Arrays.sort(string2);

        return Arrays.equals(string1, string2);

    }
}



