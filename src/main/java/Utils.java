import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Andrew on 3/13/2016.
 * The Utils class keeps all the static functions that could be accessed through the application
 * It could not be instantiated as objects
 */
public class Utils {
    // Can't create an object of Utils
    private Utils() {}

    /**
     * The tokenize function takes a string (basically a sentence) and breaks it to a list of words
     * By words, this function assumes the word is break by one of the [ \t\n\x0B\f\r] character
     * This function also removed non printable, non english characters
     * @param: sentence String
     * @return: List of String
     */
    public static ArrayList<String> tokenize(String sentence) {
        // Assumption from the "Spec"
        // input contains only spaces, newlines, standard English letters, and standard English punctuation marks.
        // Step 1: Remove non-printable and non-space characters
        // \p{Print} contains: alphanumeric character, special characters [!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~], 0x20
        // \p{Space} contains: [ \t\n\x0B\f\r]
        // All other special characters (Including non-ascii code) are simply removed
        String sentenceClean = sentence.replaceAll("[^\\p{Print}\\p{Space}]", "");

        // Step 2: Replace all punctuation characters as space except ".", "-", "'"
        // The reason to keep "." is for abbreviation such as "e.g."
        // The reason to keep "-" is for hyphenated word
        // The reason to keep "'" is for contraction
        // But need to remove the case where "-" is not used for word hyphenate
        // And also need to remove the case when "'" is not used for contraction, where there is space before/after '
        // It also assumes hyphenated word would not have space between "-" and the words
        sentenceClean = sentenceClean.replaceAll("-{2,}", " ").replaceAll("- ", " ").replaceAll(" -", " ");
        sentenceClean = sentenceClean.replaceAll("'{2,}", " ").replaceAll("' ", " ").replaceAll(" '", " ");
        sentenceClean = sentenceClean.replaceAll("(?!\\.)(?!-)(?!\\')\\p{Punct}", " ");

        // Step 3: Trim the sentenceClean to remove leading and trailing spaces
        // If the last character is "." or , remove it
        sentenceClean = sentenceClean.trim();
        sentenceClean = sentenceClean.replaceAll("[\\.\\!\\?]+$", "");

        /*
        int sLen = sentenceClean.length();
        if (sLen > 0 && (sentenceClean.charAt(sLen - 1) == '.' ||
                sentenceClean.charAt(sLen - 1) == '?' ||
                sentenceClean.charAt(sLen - 1) == '!')) {
            sentenceClean = sentenceClean.replaceAll("\\.+$", "");
        }
*/
        if (sentenceClean.length() == 0)
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
