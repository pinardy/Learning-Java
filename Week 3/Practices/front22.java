/**
 * Created by Pin on 27-Sep-16.
 *
 Given a string, take the first 2 chars and return the string
 with the 2 chars added at both the front and back, so "kitten" yields "kikittenki".
 If the string length is less than 2, use whatever chars are there.
 */

public class front22 {
    public static void main(String[] args) {
        front22 frontadder = new front22();
        System.out.println(front22("Ha"));
    }
    public static String front22(String str) {
        String output;
        if (str.length()>=2){
            String first2Chars = str.substring(0,2);
            output = first2Chars + str + first2Chars;
        }
        else{
            output = str+str+str;
        }
        return output;
    }

}
