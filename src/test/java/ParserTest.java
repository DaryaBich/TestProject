import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class ParserTest {

    @Test
    public void testPageLapkinsParse() {
        try {
            LinkedList<String> lines =  Parser.parse("https://lapkins.ru");
            Assert.assertEquals("Lapkins.ru — собаки, кошки и их хозяева",lines.get(0));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new AssertionError("Error: "+ Arrays.toString(e.getStackTrace()));
        }
    }

    @Test
    public void testSimbirsoftParse(){
        try {
            LinkedList<String> lines =  Parser.parse("https://www.simbirsoft.com/");
            Assert.assertTrue(lines.contains("SimbirSoft"));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new AssertionError("Error: "+ Arrays.toString(e.getStackTrace()));
        }
    }
}