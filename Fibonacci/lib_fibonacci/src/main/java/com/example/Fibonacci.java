package com.example;

public class Fibonacci {
    public static void main(String[] args) {

        int n1 = 0, n2 = 1, n3, i, count = 20;
        // System.out.print(n1+" "+n2);  //printing 0 and 1

        String output = String.valueOf(n1 + "," + n2);
        // System.out.println(output);
        // output += ",";
        // System.out.println(output);

        for (i = 2; i < count; ++i) {
            n3 = n1 + n2;
            String.valueOf(n3);
            // System.out.print(" "+n3);
            output += "," + String.valueOf(n3);
            n1 = n2;
            n2 = n3;
        }
//         return output;
        System.out.print(output);


    }
}