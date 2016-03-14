import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by bilongc on 3/12/2016.
 */
public class Corpus {
    private HashMap<String, ArrayList<Integer>> corpusOccurs;
    private int maxCorpusLen;

    public Corpus() {
        corpusOccurs = new HashMap<String, ArrayList<Integer>>();
        maxCorpusLen = 0;
    }

    public void add(String word, int sid) {
        maxCorpusLen = Math.max(maxCorpusLen, word.length());

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
