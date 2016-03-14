import java.text.BreakIterator;
import java.util.Locale;

/**
 * Created by Andrew on 3/13/2016.
 */
public class Sentences {
    private BreakIterator boundary = BreakIterator.getSentenceInstance(Locale.ENGLISH);
    private String myStr;
    private int boundaryPtr;

    public Sentences(String str) {
        /*
        myStr = "A \"concordance\" is an alphabetical list of the words present in a text with a count of how\n" +
                "often each word appears and citations of where each word appears in the text (e.g., page\n" +
                "number). Write a program -- in the programming language of your choice -- that will\n" +
                "generate a concordance of an arbitrary text document written in English: the text can be\n" +
                "read from stdin, and the program should output the concordance to stdout or a file. For\n" +
                "each word, it should print the count and the sorted list of citations, in this case the\n" +
                "zero-indexed sentence number in which that word occurs. You may assume that the input\n" +
                "contains only spaces, newlines, standard English letters, and standard English punctuation\n" +
                "marks.";
                */
        myStr = str;
        boundary.setText(myStr);
        boundaryPtr = boundary.first();
    }

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

    public boolean hasNext() {
        return boundaryPtr != BreakIterator.DONE;
    }
}
