import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.LinkedList;

public class HtmlWordStatistic {
    
    private HtmlWordStatistic() {
    }

    public void getAndPrintWordStatistic(String url) {
        try {
            LinkedList<String> stripesAccumulator = Parser.parse(url);
            TextWorker.splitAndPrintText(stripesAccumulator);
        } catch (IOException e) {
            System.out.println("Not correct url, please check");
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            System.out.println("Problem with parser, please try again");
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("Problem with SAX, please try again");
            e.printStackTrace();
        }
    }
}
