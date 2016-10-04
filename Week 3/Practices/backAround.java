/**
 * Created by Pin on 27-Sep-16.
 */

/* Given a string, take the last char and return
a new string with the last char added at the front and back,
so "cat" yields "tcatt".
The original string will be length 1 or more.   */

public class backAround {
    public static void main(String[] args) {
        backAround string = new backAround();
        System.out.println(string.toTheBack("cat"));
    }

    public static String toTheBack(String str) {

        char lastChar = str.charAt(str.length()-1);
        String output = lastChar + str + lastChar;
        return output;
    }

}


