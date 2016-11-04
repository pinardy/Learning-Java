import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Pin on 03-Nov-16.
 * Problem Wk.8.5.1: Regex for web address

Write a regular expression JAVA program that validate the web format as follow:
	POT://INTMID.END

•	POT:= http or https or ftp
•	INT := www. or m. or empty
•	MID := length of at least 1. Any combination of small letter, capital letter, number, “_”, or “-”
•	END:= com or edu or net             */

public class WebAddr {
    public static boolean webValidate (String input){
        Pattern p = Pattern.compile("^(http|https|ftp)(://)(www\\.|m\\.|())([a-zA-Z0-9(-|_)])+(com|edu|net)$");
        Matcher m = p.matcher(input);

        if (m.find()){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(webValidate("http://www.google.com"));
        System.out.println(webValidate("https://google.net"));
        System.out.println(webValidate("ftp://m.haha_123.edu"));
    }
}
