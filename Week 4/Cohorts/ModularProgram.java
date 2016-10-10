import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Pin on 04-Oct-16.
 * Problem Wk.4.1.1: ModularProgram
 */

public class ModularProgram {
    public static void main(String[] args) {
        System.out.println("Welcome to the modulus computer");
        boolean flag = false;

        while (flag == false) { // 'y' is entered
            try {
                System.out.println("Enter two integer values");
                Scanner input = new Scanner(System.in);
                int num1 = input.nextInt();
                int num2 = input.nextInt();
                int modulus = num1 % num2;

            } catch (ArithmeticException ae) {
                System.out.println("Sorry, cannot compute mod by 0");
                System.out.println("Do another pair of values? (y)");
                Scanner anotherInput = new Scanner(System.in);
                char yesOrNo = anotherInput.next().charAt(0);
                if (yesOrNo != 'y') break;
                else{
                    continue;
                }

            } catch (InputMismatchException ime) {
                System.out.println("Sorry, you must enter two integer values");
                System.out.println("Do another pair of values? (y)");
                Scanner anotherInput = new Scanner(System.in);
                char yesOrNo = anotherInput.next().charAt(0);
                if (yesOrNo != 'y') break;
                else{
                    continue;
                }

            } catch(NumberFormatException nfe) {
                System.out.print("Enter an integer:");
                continue;
            }

            flag = true; // not 'y' is entered
        }
    }
}


