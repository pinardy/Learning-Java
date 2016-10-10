/**
 * Created by Pin on 07-Oct-16.
 * Problem Wk.4.5.2: SongCard
 */

public class SongCard {
    //data
    private static int songs;
    private boolean activated = false;

    // Methods
    public SongCard(int n){
        songs = n;
    }
    public void activate(){
        activated = true;
    }
    public void buyASong() throws CardNotActivatedException, CardEmptyException {
        // throwing the 2 exceptions here
        if (songs == 0){
            throw new CardEmptyException("No more songs on the card");
        } else if (activated == false) {
            throw new CardNotActivatedException("Card not activated");
        }
        songs -= 1;
    }

    public int songsRemaining(){
        return songs;
    }
    public String toString(){
        String songsLeft = String.valueOf(songs);
        String notOrNot="";

        if (activated==true) {
            notOrNot = "";
        } else if (activated==false) {
            notOrNot = "not";
        }
        String outputMsg = "Card has " + songsLeft +
                " songs and is " + notOrNot + " activated";
        String outputMsgEdited = outputMsg.replaceAll("  ", " ");
        return outputMsgEdited;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SongCard sc = new SongCard(10);
        System.out.println(sc);

        System.out.println("");

        System.out.println("Trying to buy a song");
        try{
            sc.buyASong();

        } catch (CardEmptyException e){
            System.out.println("Caught error: " +e.getMessage() );
        } catch (CardNotActivatedException e){
            System.out.println("Caught error: " +e.getMessage() );
        }
        System.out.println(sc);

        System.out.println("Activating the card");
        sc.activate();
        System.out.println(sc);
        System.out.printf("%n"); // blank line
        System.out.println("Buying songs");

        while (sc.songsRemaining()>=0){
            try{
                sc.buyASong();
                System.out.println("Bought a song: " + sc);
            } catch (CardEmptyException e){
                System.out.println("Caught error: " +e.getMessage() );
                break;
            } catch (CardNotActivatedException e){
                System.out.println("Caught error: " +e.getMessage() );
                break;
            }
        }
        System.out.println(sc);
    }
}

//public class CardNotActivatedException extends Exception{
//    public CardNotActivatedException(){
//    }
//    public CardNotActivatedException(String message){
//        super(message);
//    }
//}
//
//public class CardEmptyException extends Exception {
//    public CardEmptyException(){
//    }
//    public CardEmptyException(String message){
//        super(message);
//    }
//}





