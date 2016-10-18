import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Pin on 10-Oct-16.
 * Problem Wk.5.1.5: Punctuation
 */
public class CheckSentence {
    public static String chkSentence(String input) {
        if (input.matches(".*(-|\\?)(s ).*") || input.matches(".*(\\?|-)")) {
            return "Found bad Sentence: " + input;
        } else {
            return "Found good Sentence: " + input;
        }
    }

    public static void main(String[] args) {
        System.out.println(chkSentence("Timothy's Java program is done?"));
        System.out.println(chkSentence("I like SUTD."));
        System.out.println(chkSentence("It?s a Cloudy day."));
        System.out.println(chkSentence("All's well that ends well-"));
        System.out.println(chkSentence("All's well that ends well."));
        System.out.println(chkSentence("All-s well that ends well."));
    }
}
