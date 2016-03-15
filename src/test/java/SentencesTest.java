import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andrew on 3/14/2016.
 */
public class SentencesTest {

    @Test
    public void testGetNextSentence() throws Exception {
        String test0 = "A \"concordance\" is an alphabetical list of the words present in a text with a count of how\n" +
                "often each word appears and citations of where each word appears in the text (e.g., page\n" +
                "number). Write a program -- in the programming language of your choice -- that will\n" +
                "generate a concordance of an arbitrary text document written in English: the text can be\n" +
                "read from stdin, and the program should output the concordance to stdout or a file. For\n" +
                "each word, it should print the count and the sorted list of citations, in this case the\n" +
                "zero-indexed sentence number in which that word occurs. You may assume that the input\n" +
                "contains only spaces, newlines, standard English letters, and standard English punctuation\n" +
                "marks.";

        Sentences tester0 = new Sentences(test0);

        assertEquals(true, tester0.hasNext());
        String sentence1 = "A \"concordance\" is an alphabetical list of the words present in a text with a count of how\n" +
                "often each word appears and citations of where each word appears in the text (e.g., page\n" +
                "number). ";
        assertEquals(sentence1, tester0.getNextSentence());

        assertEquals(true, tester0.hasNext());
        String sentence2 = "Write a program -- in the programming language of your choice -- that will\n" +
                "generate a concordance of an arbitrary text document written in English: the text can be\n" +
                "read from stdin, and the program should output the concordance to stdout or a file. ";

        assertEquals(sentence2, tester0.getNextSentence());

        assertEquals(true, tester0.hasNext());
        String sentence3 = "For\n" +
                "each word, it should print the count and the sorted list of citations, in this case the\n" +
                "zero-indexed sentence number in which that word occurs. ";

        assertEquals(sentence3, tester0.getNextSentence());

        assertEquals(true, tester0.hasNext());
        String sentence4 = "You may assume that the input\n" +
                "contains only spaces, newlines, standard English letters, and standard English punctuation\n" +
                "marks.";
        assertEquals(sentence4, tester0.getNextSentence());

        assertEquals(true, tester0.hasNext());
        assertEquals("", tester0.getNextSentence());
        assertEquals(false, tester0.hasNext());

    }

    @Test
    public void testGetNextSentence1() throws Exception {
        String test1 = "Preface By The Editor.\n" +
                "\n" +
                "The great work of Gibbon is indispensable to the student of history. The\n" +
                "literature of Europe offers no substitute for \"The Decline and Fall of\n" +
                "the Roman Empire.\" It has obtained undisputed possession, as rightful\n" +
                "occupant, of the vast period which it comprehends. However some\n" +
                "subjects, which it embraces, may have undergone more complete\n" +
                "investigation, on the general view of the whole period, this history\n" +
                "is the sole undisputed authority to which all defer, and from which\n" +
                "few appeal to the original writers, or to more modern compilers. The\n" +
                "inherent interest of the subject, the inexhaustible labor employed upon\n" +
                "it; the immense condensation of matter; the luminous arrangement; the\n" +
                "general accuracy; the style, which, however monotonous from its\n" +
                "uniform stateliness, and sometimes wearisome from its elaborate ar.,\n" +
                "is throughout vigorous, animated, often picturesque always commands\n" +
                "attention, always conveys its meaning with emphatic energy, describes\n" +
                "with singular breadth and fidelity, and generalizes with unrivalled\n" +
                "felicity of expression; all these high qualifications have secured, and\n" +
                "seem likely to secure, its permanent place in historic literature.\n" +
                "\n" +
                "This vast design of Gibbon, the magnificent whole into which he has cast\n" +
                "the decay and ruin of the ancient civilization, the formation and birth\n" +
                "of the new order of things, will of itself, independent of the laborious\n" +
                "execution of his immense plan, render \"The Decline and Fall of the Roman\n" +
                "Empire\" an unapproachable subject to the future historian: [101] in the\n" +
                "eloquent language of his recent French editor, M. Guizot:--\n" +
                "\n" +
                "[Footnote 101: A considerable portion of this preface has already appeared\n" +
                "before us public in the Quarterly Review.]\n";

        Sentences tester1 = new Sentences(test1);

        assertEquals(true, tester1.hasNext());
        String s1 = "Preface By The Editor.\n\n";
        assertEquals(s1, tester1.getNextSentence());

        assertEquals(true, tester1.hasNext());
        String s2 = "The great work of Gibbon is indispensable to the student of history. ";
        assertEquals(s2, tester1.getNextSentence());

        assertEquals(true, tester1.hasNext());
        String s3 = "The\n" +
                "literature of Europe offers no substitute for \"The Decline and Fall of\n" +
                "the Roman Empire.\" ";
        assertEquals(s3, tester1.getNextSentence());

        assertEquals(true, tester1.hasNext());
        String s4 = "It has obtained undisputed possession, as rightful\n" +
                "occupant, of the vast period which it comprehends. ";
        assertEquals(s4, tester1.getNextSentence());

        assertEquals(true, tester1.hasNext());
        String s5 = "However some\n" +
                "subjects, which it embraces, may have undergone more complete\n" +
                "investigation, on the general view of the whole period, this history\n" +
                "is the sole undisputed authority to which all defer, and from which\n" +
                "few appeal to the original writers, or to more modern compilers. ";
        assertEquals(s5, tester1.getNextSentence());
    }
}