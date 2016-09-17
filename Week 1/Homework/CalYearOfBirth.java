/**
 * Created by Pin on 17-Sep-16.
 * Problem Wk.1.5.1: Birth Year Generator
 */

public class CalYearOfBirth {
    public static int calYearOfBirth(int yearCurrent, int age) {
        return yearCurrent - age;
    }

    public static void main(String[] args) {
        System.out.println(calYearOfBirth(2013,8));
    }
}
