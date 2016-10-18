/**
 * Created by Pin on 12-Oct-16.
 * Problem Wk.5.5.7: Medical Information
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckData {
    public static String readTextData(String input) {
        Pattern p = Pattern.compile("^(\\d{2})(:)(\\d{2})(:)(\\d{2})\\s(\\d{2})(-)(\\d{2})(-)(\\d{4})\\s*((\\w{4})?(\\w{3})?(\\w{2})?)$");
        Matcher m = p.matcher(input);

        boolean isThereError = true;
        if (m.find()) {
            String vitalSign = m.group(11);
            char[] vitalSignArray = vitalSign.toCharArray();

            if (vitalSignArray[0] == 'S' && vitalSignArray[1] == 'p' &&
                    vitalSignArray[2] == 'O' && vitalSignArray[3] == '2') {
                isThereError = false;
            }
            if (vitalSignArray[0] == 'R' && vitalSignArray[1] == 'e' &&
                    vitalSignArray[2] == 's' && vitalSignArray[3] == 'p') {
                isThereError = false;
            }
            if (vitalSignArray[0] == 'H' && vitalSignArray[1] == 'R') {
                isThereError = false;
            }
        }
        String msg="";
        if (isThereError == false) {
            msg = "No error";
        }
        if (isThereError == true) {
            msg = "Error";
        }
        return input + " " + msg;
    }

    public static void main(String[] args) {
        System.out.println(readTextData("16:01:04 12-04-1995 SpO2"));
        System.out.println(readTextData("23:56:55 11-13-2001 SpO3"));
        System.out.println(readTextData("04:11:455 13-11-2001 HR"));
        System.out.println(readTextData("04:11:45 13-11-2001 HR"));
        System.out.println(readTextData("043:11:455 13-11-2001 SpO2"));
    }
}
