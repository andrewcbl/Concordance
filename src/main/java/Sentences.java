import java.text.BreakIterator;
import java.util.Locale;

/**
 * Created by Andrew on 3/13/2016.
 * The Sentences class breaks a string into sentences.
 * When constructed, it is initialized with the string, and the class has the capability to read one sentence
 * at a time from the object and keeps track of the end of the string.
 * The class uses BreakIterator to break string into sentences, it supports terminator of ".", '?", "!"
 */
public class Sentences {
    private BreakIterator boundary = BreakIterator.getSentenceInstance(Locale.ENGLISH);
    private String myStr;
    private int boundaryPtr;

    // Constructor, initialize with a string to work on
    public Sentences(String str) {
        myStr = str;
        boundary.setText(str);
        boundaryPtr = boundary.first();
    }

    /**
     * This function get one sentence from the String. Upon every call, the class update the read pointer
     * @return
     */
    public String getNextSentence() {
        int next = boundary.next();
        if (next != BreakIterator.DONE) {
            String result = myStr.substring(boundaryPtr, next);
            boundaryPtr = next;
            return result;
        } else {
            boundaryPtr = next;
            return "";
        }
    }

    /**
     * This function keeps track whether there is remaining sentence that is not read before
     * @return
     */
    public boolean hasNext() {
        return boundaryPtr != BreakIterator.DONE;
    }
}
