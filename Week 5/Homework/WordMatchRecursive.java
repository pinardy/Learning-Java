/**
 * Created by Pin on 16-Oct-16.
 * Problem Wk.5.5.9: Matching Word - Part b
 */
import java.util.ArrayList;
import java.util.Arrays;

public class WordMatchRecursive {

    public static ArrayList<String> returnWords(String word, String sentence){
        String[] wordsInSent = sentence.split("\\s");
        ArrayList<String> wordsFound = new ArrayList<String>();

        findWords(word, wordsInSent, wordsFound);
        return wordsFound;
    }

    public static void findWords(String word, String[] wordsArray, ArrayList<String> found){
        // base case
        if (wordsArray.length==1 && wordMatch(word, wordsArray[0])){
            found.add(wordsArray[0]);

            // smaller subproblem
        } else {
            if (wordMatch(word, wordsArray[0])) {
                found.add(wordsArray[0]);
            }
            
            //recursive call
            findWords(word, Arrays.copyOfRange(wordsArray, 1, wordsArray.length), found);
        }
    }

    public static boolean wordMatch(String in1, String in2) {
        int count=0;
        for (int i=0; i<in1.length(); i++) {
            if (in2.contains(in1.substring(i, i+1))) {
                count += 1;
            }
        }
        return count == in1.length();
    }

    public static void main(String[] args) {
        System.out.println(returnWords("left", "this stressful time on the twelfth felt strangely uneventful"));
    }
}
