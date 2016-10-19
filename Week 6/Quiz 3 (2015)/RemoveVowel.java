/**
 * Created by Pin on 19-Oct-16.
 */
public class RemoveVowel {

    private static String vowels = "aeiou";

    public static String recurRemoveVowel(String s) {
        // base case
        if (s.length()==0) {
            return s;
        }
        if (vowels.contains(s.substring(0,1).toLowerCase())) {
            return recurRemoveVowel(s.substring(1));
        } else {
            return s.charAt(0) + recurRemoveVowel(s.substring(1));
        }


    }
    public static void main(String[] args) {
        System.out.println(RemoveVowel.recurRemoveVowel("It is said ..."));
        System.out.println(RemoveVowel.recurRemoveVowel(""));
        System.out.println(RemoveVowel.recurRemoveVowel("GCD"));
        System.out.println(RemoveVowel.recurRemoveVowel("Hello Java"));
    }

}
/*
----Output----
t s sd ...

GCD
Hll Jv

 */
