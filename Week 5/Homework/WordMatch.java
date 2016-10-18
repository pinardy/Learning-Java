/**
 * Created by Pin on 16-Oct-16.
 * Problem Wk.5.5.8: Matching Word - Part a
 */
public class WordMatch {
    public static boolean wordMatch(String in1, String in2){
        for(int i=0;i<in1.length(); i++){
            if(in2.contains(in1.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(wordMatch("dog","doggy"));
    }
}
