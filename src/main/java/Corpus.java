import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * The Corpus class has the following features:
 * - It keeps track of the word that appeared
 * - It keeps track of the maximum length of the corpus
 * - It keeps track of the sentence id when the corpus is inserted
 * Created by bilongc on 3/12/2016.
 */
public class Corpus {
    private HashMap<String, ArrayList<Integer>> corpusOccurs;
    private int maxCorpusLen;

    /**
     * Constructor, initialize the dictionary which keeps track of corpus
     */
    public Corpus() {
        corpusOccurs = new HashMap<String, ArrayList<Integer>>();
        maxCorpusLen = 0;
    }

    /**
     * Add word to the corpus hashMap
     * If the word was added before, just append to the dictionary value
     * If the word was never added, create a new ArrayList and add that to the dictionary
     * @param word
     * @param sid
     */
    public void add(String word, int sid) {
        maxCorpusLen = Math.max(maxCorpusLen, word.length());

        // Only contains lowercase corpus
        String wordKey = word.toLowerCase();

        if (corpusOccurs.containsKey(wordKey)) {
            corpusOccurs.get(wordKey).add(sid);
        } else {
            ArrayList<Integer> occurs = new ArrayList<Integer>();
            occurs.add(sid);
            corpusOccurs.put(wordKey, occurs);
        }
    }

    public Set<String> getCorpus() {
        return corpusOccurs.keySet();
    }

    public HashMap<String, ArrayList<Integer>> getConcordance() {
        return corpusOccurs;
    }

    public int getMaxCorpusLen() {
        return maxCorpusLen;
    }
}
