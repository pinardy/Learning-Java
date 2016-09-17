import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Pin on 17-Sep-16.
 * Problem Wk.1.5.4: Hailstone Sequence Counter
 */


public class HailstonesCount{
    public static int Counter(int n) {
        int counter = 0;
        while (n!=1){
            if (n%2==0){
                n=n/2;
                counter+=1;
            } else {
                n=3*n+1;
                counter+=1;
            }
        }
        return counter;
}
    // ======== Using ArrayList for Hailstone sequence ======== //
    public static ArrayList<Integer> HailStoneArrayList(int n){
        ArrayList<Integer> listOfIntegers = new ArrayList<>();
        while (n!=1){
            listOfIntegers.add(n);
            if (n%2==0){
                n=n/2;
            } else {
                n=3*n+1;
            }
        }
        listOfIntegers.add(n); //adding '1' to list
        return listOfIntegers;
    }

    // ======== Using LinkedList for Hailstone sequence ======== //

    public static LinkedList<Integer> HailStoneLinkedList(int n){
        LinkedList<Integer> listOfIntegers = new LinkedList<>();
        while (n!=1){
            listOfIntegers.add(n);
            if (n%2==0){
                n=n/2;
            } else {
                n=3*n+1;
            }
        }
        listOfIntegers.add(n); //adding '1' to list
        return listOfIntegers;
    }

// ------------------------------------------------------------ //
    public static void main(String[] args) {
        System.out.println(Counter(999)); // For homework
//        System.out.println(HailStoneArrayList(10)); // Using ArrayList
//        System.out.println(HailStoneLinkedList(10)); // Using LinkedList
    }
}