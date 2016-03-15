import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Created by Andrew on 3/14/2016.
 */
public class CorpusTest {

    @Test
    public void testCorpusMethods() throws Exception {
        // Test adding one word
        Corpus testCorpus = new Corpus();
        testCorpus.add("testing", 0);
        assertEquals(7, testCorpus.getMaxCorpusLen());

        HashSet<String> expCorpus = new HashSet<String>();
        expCorpus.add("testing");
        assertEquals(expCorpus, testCorpus.getCorpus());

        // Add another word with upper case
        testCorpus.add("TESTING", 1);
        assertEquals(7, testCorpus.getMaxCorpusLen());
        assertEquals(expCorpus, testCorpus.getCorpus());

        // Add another word
        testCorpus.add("JustAnotherTest", 10);
        assertEquals(15, testCorpus.getMaxCorpusLen());
        expCorpus.add("justanothertest");
        assertEquals(expCorpus, testCorpus.getCorpus());
    }
}