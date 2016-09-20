
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pin on 17-Sep-16.
 * Problem Wk.1.5.6: White Space Trimmer
 */

public class ListTrim {
    public static void main(String[] args) {
        List<String> testString = new ArrayList<String>(Arrays.asList(" red "," blue "," green "));
        System.out.println(listTrim(testString));
        }

    public static List<String> listTrim(List<String> strings) {
        ArrayList<String> output = new ArrayList<String>();

        for (String i : strings) {
            output.add(i.trim());
        }
        return output;
    }
}