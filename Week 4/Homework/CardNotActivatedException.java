/**
 * Created by Pin on 10-Oct-16.
 */
public class CardNotActivatedException extends Exception{
    public CardNotActivatedException(){
    }
    public CardNotActivatedException(String message){
        super(message);
    }
}
