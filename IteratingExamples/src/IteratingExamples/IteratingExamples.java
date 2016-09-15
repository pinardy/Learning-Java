package IteratingExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Pin on 14-Sep-16.
 */
// Problem Wk.1.2.1: Iterating with Iterator

public class IteratingExamples {

    public static void main(String[] args) {

/*-------  This is a more cumbersome way of initializing a list -----*/
//        Integer[] x = new Integer[5];
//        x[0]=1;x[1]=2;x[2]=3;x[3]=4;x[4]=5;
//        List<Integer> in = new ArrayList<>(Arrays.asList(x));
//        List<Integer> in = new ArrayList<Integer>(Arrays.asList(x));  This works fine as well
/* ------------------------------------------------------------*/
        List<Integer> in = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        System.out.println(Act2Iterator(in));
    }
// ==============================================================
    public static int Act2Iterator(List<Integer> integers) {
        int sum = 0;
        Iterator<Integer> iter = integers.iterator();

        while (iter.hasNext()) {
            sum += iter.next();
        }
        return sum;

    }
}