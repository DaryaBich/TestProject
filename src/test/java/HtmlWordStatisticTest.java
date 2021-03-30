import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HtmlWordStatisticTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testGetAndPrintWordStatistic() {
        HtmlWordStatistic.getAndPrintWordStatistic("https://lapkins.ru");
        String content = outContent.toString();
        Assert.assertTrue(content.contains("кот") && content.contains("собака") && content.contains("щенок"));
    }

    @Test
    public void testFailGetAndPrintWordStatistic(){
        HtmlWordStatistic.getAndPrintWordStatistic("lapkins.ru");
        String result = outContent.toString();
        Assert.assertEquals("Your url isn't correct and I rewrite it on https://www.simbirsoft.com/",
                result.substring(0, result.indexOf("\n")));
    }
}
