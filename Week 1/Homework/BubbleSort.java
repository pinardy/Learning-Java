import static java.lang.System.in;

/**
 * Created by Pin on 17-Sep-16.
 * Problem Wk.1.5.5: Integer sorter
 */

public class BubbleSort {

    public static int[] bubbleSort(int[] inarray) {
        int size = inarray.length;
        int startPosition = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 1; j < (size - i); j++) {
                if (inarray[j - 1] > inarray[j]) {
                    //swap elements
                    startPosition = inarray[j - 1];
                    inarray[j - 1] = inarray[j];
                    inarray[j] = startPosition;
                }
            }
        }

        for (int i = 0; i < inarray.length; i++) {
            System.out.print(inarray[i] + " ");

        }
        return inarray;
    }

    public static void main(String[] args) {
        int[] array = {2, -3, 1, 5, 0, -10};
        System.out.println(bubbleSort(array));
    }
}
