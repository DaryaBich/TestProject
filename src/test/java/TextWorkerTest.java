import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;

public class TextWorkerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testHelloWorldSplitAndPrintText() {
        LinkedList<String> lines = new LinkedList<>();
        lines.add("Hello world!");
        lines.add("How are you, world?");
        TextWorker.splitAndPrintText(lines);
        Assert.assertEquals("world -> 2\n" +
                "are -> 1\n" +
                "hello -> 1\n" +
                "how -> 1\n" +
                "you -> 1\n", outContent.toString());
    }

    @Test
    public void testSplitAndPrintText(){
        LinkedList<String> lines = new LinkedList<>();
        lines.add("Jingle bells, jingle bells\nJingle all the way\nOh, what fun it is to ride\n" +
                "In a one horse open sleigh");
        lines.add("Hey, jingle bells, jingle bells\nJingle all the way\nOh, what fun it is to ride\n" +
                "In a one horse open sleigh");
        lines.add("Jingle bells, jingle bells\nJingle all the way\nOh, what fun it is to ride\n" +
                "In a one horse open sleigh");
        lines.add("Hey, jingle bells, jingle bells\nJingle all the way\nOh, what fun it is to ride\n" +
                "In a one horse open sleigh\nIt's Christmas ©");
        TextWorker.splitAndPrintText(lines);
        Assert.assertEquals("jingle -> 12\n" +
                "bells -> 8\n" +
                "a -> 4\n" +
                "all -> 4\n" +
                "fun -> 4\n" +
                "horse -> 4\n" +
                "in -> 4\n" +
                "is -> 4\n" +
                "it -> 4\n" +
                "oh -> 4\n" +
                "one -> 4\n" +
                "open -> 4\n" +
                "ride -> 4\n" +
                "sleigh -> 4\n" +
                "the -> 4\n" +
                "to -> 4\n" +
                "way -> 4\n" +
                "what -> 4\n" +
                "hey -> 2\n" +
                "christmas -> 1\n" +
                "it's -> 1\n", outContent.toString());
    }
}