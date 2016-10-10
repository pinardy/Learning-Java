/**
 * Created by Pin on 07-Oct-16.
 * Problem Wk.4.1.3: Q3a, CatchExceptions
 *
 * An exception is thrown in method3 and is caught in method1.
 * Print the statements that are executed.
 * Use CatchingExceptionsv4.java
 */

import java.util.*;
public class CatchingExceptionsv4 {
    public static void main(String[] args) throws Throwable {
        try{
            method1();
            System.out.println("Statement 1: Running method 1");
      } catch(NullPointerException ex) {
            System.out.println(ex);
      }
        System.out.println("Statement 2: Program running in main...");
    }

    public static void method1() throws Exception{
        try{
            method2();
            System.out.println("Statement 3: Running method 2");
        } catch(Exception ex2) { // why not NullPointerException instead?
            System.out.println(ex2);
//            System.out.println("Exception caught in method1");
        }
        System.out.println("Statement 4: Program running in method1...");
    }
    public static void method2() throws Exception{
        try{
            method3();
            System.out.println("Statement 5: Running method 2");
        } catch(NullPointerException ex3) { // why not Exception instead?
            System.out.println(ex3);
//            System.out.println("Exception caught in method2");
        }
        System.out.println("Statement 6: Program running in method2...");
    }
    public static void method3() throws Exception{
        IllegalArgumentException ex4 = new IllegalArgumentException("Info from method2");
        throw ex4;
    }
}
