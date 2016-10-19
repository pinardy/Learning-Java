/**
 * Created by Pin on 18-Oct-16.
 */
public class InvalidTest extends Exception {
    public InvalidTest() {
    }

    public InvalidTest(String message) {
        super(message);
    }

    public static void testScores(double[] s) throws InvalidTest {
        for (int i=0; i<s.length; i++){
            if (s[i]<0 || s[i]>100){
                throw new InvalidTest("Score negative or bigger than 100: "+Double.toString(s[i]));
            }
        }
    }
}
