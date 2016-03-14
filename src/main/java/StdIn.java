/**
 * Created by Andrew on 3/13/2016.
 * Modified from: ftp://ftp.cs.princeton.edu/pub/cs226/map/StdIn.java
 */
import java.io.IOException;

public class StdIn {
    private static int c = ' ';
    private static final int EOF = -1;
    private static final int EOT = 4;

    // can't create an instance of this class
    private StdIn() { }

    // is the current character whitespace?
    private static boolean isBlank() {
        return Character.isWhitespace((char) c);
    }

    // is it at end of the file already?
    private static boolean isEOF() { return c == EOF; }

    // is it at end of the transfer already
    private static boolean isEOT() { return c == EOT;}

    // return EOF if end of file or IO error
    private static void readC() {
        try { c = System.in.read(); }
        catch(IOException e) { c = EOF; }
    }

    // is there more input?
    public static boolean isEmpty() {
        while (!isEOF() && isBlank())
            readC();
        return isEOF();
    }

    // read a token - use StringBuffer for efficiency
    public static String readString() {
        StringBuffer s = new StringBuffer();

        // eat up whitespace
        while (!isEOF() && isBlank())
            readC();

        // now get the string
        while (!isEOF() && !isEOT()) {
            s.append((char) c);
            readC();
        }

        if (s.length() == 0) throw new RuntimeException("Tried to read from empty stdin");
        else return s.toString();
    }

    // test client
    public static void main(String[] args) {
        // read in a String and print it out
        System.out.print("Enter a string: ");
        String z = StdIn.readString();
        System.out.println("Your string was " + z);
        System.out.println();
    }
}