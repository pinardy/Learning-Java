/**
 * Created by Pin on 07-Oct-16.
 */
/**
 * Created by Pin on 07-Oct-16.
 * Problem Wk.4.1.3: Q3b, CatchExceptions
 *
 * An exception is thrown in method3 and is not
 * caught in method2, method1, and method.
 * Print the statements that are executed.
 */

public class CatchingExceptionsv6 {
    public static void main(String[] args) throws Throwable {
        try{
            method1();
            System.out.println("Statement 1: Running method 1");
        } catch(ArithmeticException ex1) { // why NullPointerException instead of Exception?
            System.out.println(ex1);
            System.out.println("Exception caught in main method");
        }
        System.out.println("Statement 2: Program running in main...");
    }

    public static void method1() throws Exception{
        try{
            method2();
            System.out.println("Statement 3: Running method 2");
        } catch(ArithmeticException ex2) {
            System.out.println(ex2);
//            System.out.println("Exception caught in method1");
        }
        System.out.println("Statement 4: Program running in method1...");
    }
    public static void method2() throws Exception{
        try{
            method3();
            System.out.println("Statement 5: Running method 2");
        } catch(ArithmeticException ex3) {
            System.out.println(ex3);
//            System.out.println("Exception caught in method2");
        }
        System.out.println("Statement 6: Program running in method2...");
    }
    public static void method3() throws Exception{
        throw new IllegalArgumentException("Info from method2");
    }
}
