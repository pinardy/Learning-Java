/**
 * Created by Pin on 17-Sep-16.
 * Problem Wk.1.5.2: Power2 Generator
 */

public class PrintList{
    public static String printNums() {
        String output = "";
        for (int i=0; i<=7; i++){
            output += (int) Math.pow(2,i) + " ";
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(printNums());
    }
}
