/**
 * Created by Pin on 18-Oct-16.
 */
public class Test  {

    public static void main(String[] args) {
        double[] badScores = {97.5, -1.0, 88.0, 99.0, 99.0 };
        try {
            InvalidTest inv = new InvalidTest();
            inv.testScores(badScores);
        }
        catch (InvalidTest e) {
            System.out.println("Invalid score found.");
            System.out.println(e.getMessage());
//            System.out.println(e);  <-- cannot just print e, as this will along the exception
        }
    }
}




