import java.io.IOException;
import java.text.BreakIterator;
import java.util.*;

/**
 * This class is the main program for the Concordance application
 * It works with the following breakdown steps:
 * - Read in a paragraph from STDIN
 * - Break the paragraph into sentences
 * - Tokenize each of the sentence
 * - Add the words to the Corpus tracker
 * - Print/format the concordance
 * Created by bilongc on 3/12/2016.
 */
public class Concordance {
    private Corpus corpus;
    private Sentences sentences;

    /**
     * Constructor, constructed with the string to calculate concordance
     * Also, construct sentences and corpus objects
     * @param str
     */
    public Concordance(String str) {
        sentences = new Sentences(str);
        corpus = new Corpus();
    }

    /**
     * Main loop to compute concordance.
     * Call sentence breaker
     * Tokenize the sentence
     * Add the words to Corpus
     */
    private void calcConcordance() {
        int sid = 0;
        while (sentences.hasNext()) {
            String sentence = sentences.getNextSentence();
            ArrayList<String> words = Utils.tokenize(sentence);
            for (String word: words) {
                corpus.add(word, sid);
            }

            // Only increase the sentence id when it is a valid sentence, i.e. contains some words
            if (words.size() > 0)
                sid += 1;
        }
    }

    public Set<String> getCorpus() {
        if (sentences.hasNext())
            this.calcConcordance();
        return corpus.getCorpus();
    }

    /**
     * Get the Concordance from Corpus, and generate list of String for it
     * @return
     */
    public ArrayList<String> getConcordance() {
        if (sentences.hasNext())
            this.calcConcordance();
        HashMap<String, ArrayList<Integer>> corpusOccurs = corpus.getConcordance();
        Integer maxCorpusLen = corpus.getMaxCorpusLen();

        ArrayList<String> result = new ArrayList<String>();
        List<String> sortedKeys = new ArrayList<String>(corpusOccurs.keySet());
        Collections.sort(sortedKeys);

        for (String key: sortedKeys) {
            result.add(Utils.formatStats(key, corpusOccurs.get(key), maxCorpusLen));
        }

        return result;
    }

    public void printConcordance() {
        ArrayList<String> concordances = getConcordance();

        for (String elem: concordances)
            System.out.println(elem);
    }

    // Main entry class
    public static void main(String[] args) throws IOException {
        String myStr = StdIn.readString();
        Concordance concordance = new Concordance(myStr);
        concordance.printConcordance();
    }
}
