import java.io.IOException;
import java.text.BreakIterator;
import java.util.*;

/**
 * Created by bilongc on 3/12/2016.
 */
public class Concordance {
    private Corpus corpus;
    private Sentences sentences;

    public Concordance(String str) {
        sentences = new Sentences(str);
        corpus = new Corpus();
    }

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

    public static void printEachForward(BreakIterator boundary, String source) {
        int start = boundary.first();
        for (int end = boundary.next();
             end != BreakIterator.DONE;
             start = end, end = boundary.next()) {
            System.out.println(source.substring(start,end));
        }
    }

    public static void main(String[] args) throws IOException {
        String myStr = StdIn.readString();
        Concordance concordance = new Concordance(myStr);
        concordance.printConcordance();
    }
}
