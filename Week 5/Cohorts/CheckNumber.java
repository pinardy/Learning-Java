import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Pin on 12-Oct-16.
 * Problem Wk.5.1.6: Phone Number
 *
 * A valid phone number must start with the digit 6, 8 or 9, and be 8 digits long.
 * It may have a space after the fourth digit.
 * There may optionally be the sequence +65 followed by at most one space.
 */
public class CheckNumber {
    public static String chkNumber(String input) {
        // if (input.matches("^(\\+?)(65)? ?(6|8|9)\\d{3}( ?)\\d{4}$"))
        if (input.matches("((\\+65)( )?)?([0-9]{4})( )?([0-9]{4})")){
            return "Found good phone number:  " + input;
        } else {
            return "Found bad phone number: " + input;
        }
    }
    public static void main(String[] args) {
        System.out.println(chkNumber("8698 9823"));
        System.out.println(chkNumber("+65 90013321"));
        System.out.println(chkNumber("88 62319001"));
        System.out.println(chkNumber("911"));
        System.out.println(chkNumber("+656565 6565"));
    }
}