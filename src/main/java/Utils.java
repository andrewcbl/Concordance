import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Andrew on 3/13/2016.
 */
public class Utils {
    // Can't create an object of Utils
    private Utils() {}

    public static ArrayList<String> tokenize(String sentence) {
        // Assumption from the "Spec"
        // input contains only spaces, newlines, standard English letters, and standard English punctuation marks.
        // Step 1: Remove non-printable and non-space characters
        // \p{Print} contains: alphanumeric character, special characters [!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~], 0x20
        // \p{Space} contains: [ \t\n\x0B\f\r]
        // All other special characters are simply removed
        String sentenceClean = sentence.replaceAll("[^\\p{Print}\\p{Space}]", "");

        // Step 2: Replace all punctuation characters as space except "." and "-"
        // The reason to keep "." is for abbreviation such as "e.g."
        // The reason to keep "-" is for hyphenated word
        // But need to remove the case where "-" is not used for word hyphenate
        // It also assumes hyphenated word would not have space between "-" and the words
        sentenceClean = sentenceClean.replaceAll("-{2,}", " ").replaceAll("- ", " ").replaceAll(" -", " ");
        sentenceClean = sentenceClean.replaceAll("(?!\\.)(?!-)\\p{Punct}", " ");

        // Step 3: Trim the sentenceClean to remove leading and trailing spaces
        // If the last character is ".", remove it
        sentenceClean = sentenceClean.trim();

        int sLen = sentenceClean.length();
        if (sLen > 0 && sentenceClean.charAt(sLen - 1) == '.') {
            sentenceClean = sentenceClean.substring(0, sLen - 1);
        }

        if (sentence.length() == 0)
            return new ArrayList<String>();

        // Step 4: Split the sentence with the \p{Space} set
        String[] wordArray = sentenceClean.split("\\p{Space}+");

        return new ArrayList<String>(Arrays.asList(wordArray));
    }

    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }

    public static String occursToStr(ArrayList<Integer> occurs) {
        String result = "";

        for (Integer occur: occurs) {
            result += occur.toString();
            result += ',';
        }

        if (result.equals(""))
            return result;
        else
            return result.substring(0, result.length() - 1);
    }

    public static String formatStats(String key, ArrayList<Integer> occurs, Integer len) {
        return String.format("%s{%d:%s}", padRight(key, len + 1), occurs.size(), occursToStr(occurs));
    }
}
