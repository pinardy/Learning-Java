/**
 * Created by Pin on 26-Sep-16.
 * Multi-dimensional array
 */

/* Write a static method to compute the sum of the entries of a 2D array,
    not necessarily rectangular */

public class SumOfEntries {
    public static int sumArray(int[][] a) {
        int output = 0;

        for (int i = 0; i < a.length; i++) // a.length refers to the number of row
            for (int j = 0; j < a[i].length; j++)
                output += a[i][j];

        return output;
    }

}
