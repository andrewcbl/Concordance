import org.junit.Test;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Andrew on 3/14/2016.
 */
public class UtilsTest {

    @Test
    public void testTokenize() throws Exception {
        // String contains only space and newline, tokenize should return empty array
        ArrayList<String> words = Utils.tokenize(" \n  \n ");
        assertEquals(0, words.size());

        // String contains a complete sentence, should break into words
        words = Utils.tokenize("A \"concordance\" is an alphabetical list of the words present in a text with a count of how\n" +
                "often each word appears and citations of where each word appears in the text (e.g., page\n" +
                "number).");
        assertEquals(35, words.size());
        assertEquals("in", words.get(10)); // Randomly pick some elements to check
        assertEquals("appears", words.get(21));
        assertEquals("e.g.", words.get(32));

        // String contains a complete sentence, testing hyphen cases
        words = Utils.tokenize("Write a program -- in the programming language of your choice -- that will\n" +
                "generate a concordance of an arbitrary text document written in English: the text can be\n" +
                "read from stdin, and the program should output the concordance to stdout or a file. For\n" +
                "each word, it should print the count and the sorted list of citations, in this case the\n" +
                "zero-indexed sentence number in which that word occurs.");
        assertEquals(68, words.size());
        assertEquals("in", words.get(3));
        assertEquals("that", words.get(10));
        assertEquals("zero-indexed", words.get(60));

        // String contains a complete sentence, testing multiple periods in a row and contraction
        words = Utils.tokenize("After work I'll walk over to the Thunderdome, i.e., the new sports arena a few blocks away...");
        assertEquals(17, words.size());
        assertEquals("I'll", words.get(2));
        assertEquals("i.e.", words.get(8));

        // String contains a complete sentence with ? terminator
        words = Utils.tokenize("How to break this sentence ? ");
        assertEquals(5, words.size());
        assertEquals("sentence", words.get(4));

        // String contains a complete sentence with ! terminator
        words = Utils.tokenize("I really don't want to get wet, don't throw me in the pool!");
        assertEquals(13, words.size());
        assertEquals("don't", words.get(2));
        assertEquals("don't", words.get(7));
        assertEquals("pool", words.get(12));

    }

    @Test
    public void testPadRight() throws Exception {
        assertEquals("testing   ", Utils.padRight("testing", 10));
    }

    @Test
    public void testPadLeft() throws Exception {
        assertEquals("   testing", Utils.padLeft("testing", 10));
    }
}