import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.LinkedList;

public class HtmlWordStatistic {
    private String url;

    public HtmlWordStatistic(String url) {
        this.url = url;
    }

    public void printWordStatistic() {
        try {
            LinkedList<String> stripesAccumulatorText = Parser.parse(url);
            TextWorker.splitAndPrintText(stripesAccumulatorText);
        } catch (IOException e) {
            System.out.println("Not correct url, please check");
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            System.out.println("Problem with parser");
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("Problem with SAX");
            e.printStackTrace();
        }
    }
}
