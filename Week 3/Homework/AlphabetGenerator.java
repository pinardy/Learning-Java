package piwords;

import java.util.HashMap;
import java.util.Map;

public class AlphabetGenerator {
    /**
     * Given a numeric base, return a char[] that maps every digit that is
     * representable in that base to a lower-case char.
     * <p>
     * This method will try to weight each character of the alphabet
     * proportional to their occurrence in words in a training set.
     * <p>
     * This method should do the following to generate an alphabet:
     * 1. Count the occurrence of each character a-z in trainingData.
     * 2. Compute the probability of each character a-z by taking
     * (occurrence / total_num_characters).
     * 3. The output generated in step (2) is  a PDF of the characters in the
     * training set. Convert this PDF into a CDF for each character.
     * 4. Multiply the CDF value of each character by the base we are
     * converting into.
     * 5. For each index 0 <= i < base,
     * output[i] = (the first character whose CDF * base is > i)
     * <p>
     * A concrete example:
     * 0. Input = {"aaaaa..." (302 "a"s), "bbbbb..." (500 "b"s),
     * "ccccc..." (198 "c"s)}, base = 93
     * 1. Count(a) = 302, Count(b) = 500, Count(c) = 198
     * 2. Pr(a) = 302 / 1000 = .302, Pr(b) = 500 / 1000 = .5,
     * Pr(c) = 198 / 1000 = .198
     * 3. CDF(a) = .302, CDF(b) = .802, CDF(c) = 1
     * 4. CDF(a) * base = 28.086, CDF(b) * base = 74.586, CDF(c) * base = 93
     * 5. Output = {"a", "a", ... (29 As, indexes 0-28),
     * "b", "b", ... (46 Bs, indexes 29-74),
     * "c", "c", ... (18 Cs, indexes 75-92)}
     * <p>
     * The letters should occur in lexicographically ascending order in the
     * returned array.
     * - {"a", "b", "c", "c", "d"} is a valid output.
     * - {"b", "c", "c", "d", "a"} is not.
     * <p>
     * If base >= 0, the returned array should have length equal to the size of
     * the base.
     * <p>
     * If base < 0, return null.
     * <p>
     * If a String of trainingData has any characters outside the range a-z,
     * ignore those characters and continue.
     *
     * @param base         A numeric base to get an alphabet for.
     * @param trainingData The training data from which to generate frequency
     *                     counts. This array is not mutated.
     * @return A char[] that maps every digit of the base to a char that the
     * digit should be translated into.
     */
    public static char[] generateFrequencyAlphabet(int base, String[] trainingData) {
        // TODO: Implement (Problem f)
        if (base<0) return null;

        int count[] = new int[26]; // occurrence
        int total = 0; // total_num_characters
        int cdf[] = new int[26]; // initialize cdf
        char output[] = new char[base]; // initialize output

        for (int i=0; i<trainingData.length; ++i) {
            for (int j=0; j<trainingData[i].length(); ++j) {
                int charOffset = (int)(trainingData[i].charAt(j)) - 'a';
                if (charOffset>-1 && charOffset<26) {
                    count[charOffset]++;
                    total++;
                }
            }
        }

        for (int i=0; i<cdf.length; ++i) {
//            cdf[i] = (i>0 ? cdf[i-1] : 0) + count[i]; // compressing if else into a line
            if (i>0) {
                cdf[i] = cdf[i-1] + count[i];
            } else {
                cdf[i] = 0 + count[i];
            }
        }
        for (int i=0; i<base; ++i) {
            for (int j=0; j<cdf.length; ++j) {
                if (cdf[j]*base > i*total) {
                    output[i] = (char)((int)'a' + j);
                    break;
                }
            }
        }
        return output;
    }
}
