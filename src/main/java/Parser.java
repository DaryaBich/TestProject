import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;

public class Parser {
    public static LinkedList<String> parse(String url) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance(
                "de.sfuhrm.htmltosax.HtmlToSaxParserFactory",
                null
        );
        SAXParser parser = factory.newSAXParser();

        SAXStripesAccum saxStripesAccumulator = new SAXStripesAccum();
        InputStream inputStream = new URL(url).openStream();
        InputSource inputSource = new InputSource(inputStream);
        inputSource.setEncoding("UTF-8");

        parser.parse(inputSource, saxStripesAccumulator);
        return saxStripesAccumulator.getText();
    }
}
