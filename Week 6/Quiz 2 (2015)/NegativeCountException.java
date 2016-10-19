/**
 * Created by Pin on 18-Oct-16.
 */
public class NegativeCountException extends Exception {
    private int count=0;
    public NegativeCountException() {
    }

    public NegativeCountException(String message) {
        super(message);
    }
    public void addPerson(){
        count+=1;
    }
    public void removePerson() throws NegativeCountException {
        try {
//            count-=1;
            if (count <= 0) {
                throw new NegativeCountException();
            } else {
                count-=1;
            }
        }catch (NegativeCountException e) {
            System.out.println("Caught an exception: Cannot remove a person");
            System.exit(1);
        }
    }
    public int getCount(){
        return count;
    }
}
