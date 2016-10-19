/**
 * Created by Pin on 19-Oct-16.
 */
public class CountVowel {

    private static String vowels = "aeiou";

    private static int recurCountVowels(String s) {
        if(s==null||s.length()==0) {
            return 0;
        }
        //checks each character to find out if it is a vowel
        if(vowels.contains((CharSequence) s.substring(0, 1).toLowerCase())) {
            return 1 + recurCountVowels(s.substring(1));
        }
        // recursive call if char is not a vowel
        return 0 + recurCountVowels(s.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(CountVowel.recurCountVowels("It is said ..."));
        System.out.println(CountVowel.recurCountVowels(""));
        System.out.println(CountVowel.recurCountVowels("GCD"));
        System.out.println(CountVowel.recurCountVowels(
                "Hello Java"));
    }
}
/* Output:
    4
    0
    0
    4
    */


