/**
 * Created by Pin on 18-Oct-16.
 */
public class NoWhere extends Exception {
    static void test() {
        throw new NullPointerException();
    }
    public static void main(String[] args) {
        try  {
            test();
        }
        catch (NullPointerException ex) {
            System.out.println("Error: " + ex);
            ex.printStackTrace();
        }
    }
}
