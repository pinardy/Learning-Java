/**
 * Created by Pin on 12-Oct-16.
 * Problem Wk.5.5.6: NRIC
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckNRIC {
    public static String chkNRIC (String input) {
        Pattern p = Pattern.compile("^(S|T|F|G)(\\d{7})(\\w)\\s*(\\d{4})$");
        Matcher m = p.matcher(input);

        if (m.find()) {
            String firstLetter = m.group(1);
            String digits = m.group(2);
            String lastChar = m.group(4);

            char[] firstChar = firstLetter.toCharArray();
            char[] digitsArray = digits.toCharArray();
            char[] lastChar_array = lastChar.toCharArray();

            /* TutorJ's answer converts char to int with a method charToNum,
            since casting returns the ASCII value of the character

            public static int chartonum (char c) {
                    int t = ((int) c) - 48; //since casting returns the ASCII value
                    return t;
                }

             */
            int firstTwo = (digitsArray[0] - '0') * 10 + (digitsArray[1] - '0');
            int birthYear = (lastChar_array[0] - '0') * 1000 + (lastChar_array[1] - '0') * 100 +
                    (lastChar_array[2] - '0') * 10 + (lastChar_array[3] - '0');

            if (firstChar[0] == 'S') {
                if ((birthYear >= 1968) && (birthYear < 2000)) {
                    if ((birthYear % 100) == firstTwo) {
                        return ("No Error");
                    }
                }
            }
            if (firstChar[0] == 'T') {
                if ((birthYear >= 2000) && ((birthYear % 100) == firstTwo)) {
                    return ("No Error");
                } else {
                    return ("Error");
                }
            }
            if ((firstChar[0] == 'F') || (firstChar[0] == 'G')) {
                return ("No Error");
            }
        }
        return ("Error");
    }

    public static void main(String[] args) {
        System.out.println(chkNRIC("A3317213R 1963"));
        System.out.println(chkNRIC("F7931123G 1979"));
        System.out.println(chkNRIC("S7931123G 1979"));
        System.out.println(chkNRIC("T2279982L 1999"));
        System.out.println(chkNRIC("T8245336V 2012"));
    }
}
