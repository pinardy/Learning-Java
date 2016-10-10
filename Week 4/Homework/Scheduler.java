import java.lang.reflect.Array;
import java.sql.Time;
import java.util.Scanner;

/**
 * Created by Pin on 07-Oct-16.
 * Problem Wk.4.5.1: Scheduler
 */

public class Scheduler {
    public static void main(String[] args) { // do we need "throws Throwable" ?
        System.out.println("Welcome to the Appointment Scheduler");
        System.out.println("You can schedule an appointment at 1 or 2 pm.");

        Scanner reader = new Scanner(System.in);
        String appointments[] = new String[2];
        int appointmentsMade = 0; // counter

        new InvalidTimeException();
        new TimeInUseException();

        while (appointmentsMade < 2) {
                try {
                if (appointmentsMade <= 2) {
                    System.out.println("What is your name?");
                    String name = reader.nextLine();
                    System.out.println("What time would you like the appointment");
                    int appt_time = reader.nextInt();
                    reader.nextLine(); //

                    if (appt_time<1 || appt_time>2) {
                        throw new InvalidTimeException();
                    }
                    if (appointments[appt_time-1]!=null ) {
                        throw new TimeInUseException();
                    }

                    else { // set name in array
                        appointments[appt_time-1] = name;
                        appointmentsMade+=1;
                    }
                }

            } catch (InvalidTimeException invalidTime) {
                System.out.println(invalidTime);
                System.out.println("Time value not in range \n" +
                                "Sorry that is not a legal time");

            } catch (TimeInUseException timeIsUsed){
                System.out.println(timeIsUsed);
                System.out.println("Appointment already made at that time \n" +
                        "Sorry, that time is already in use");
            }
        }
        System.out.println("All appointments made");
        System.out.println("At 1pm: " + appointments[0] );
        System.out.println("At 2pm: " + appointments[1] );
    }

    public static class InvalidTimeException extends Exception{
        Exception InvalidTimeException = new Exception("Time value not in range \n " +
                "Sorry, that is not a legal time");
    }

    public static class TimeInUseException extends Exception{
        Exception TimeInUseException = new Exception("Sorry, that time is already in use");
    }

}
