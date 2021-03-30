import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.LinkedList;

@lombok.extern.slf4j.Slf4j
public final class HtmlWordStatistic {
    private HtmlWordStatistic() {
    }

    public static void getAndPrintWordStatistic(String url){
        try {
            LinkedList<String> stripesAccumulator = Parser.parse(url);
            TextWorker.splitAndPrintText(stripesAccumulator);
        }catch (IOException e) {
            System.out.println("Your url isn't correct and I rewrite it on https://www.simbirsoft.com/");
            log.error("Url "+url+" isn't correct", e);
            HtmlWordStatistic.getAndPrintWordStatistic("https://www.simbirsoft.com/");
        } catch (ParserConfigurationException e) {
            System.out.println("Problem with parser, please try again");
            log.error("Problem with parser, please try again", e);
        } catch (SAXException e) {
            System.out.println("Problem with SAX, please try again");
            log.error("Problem with SAX, please try again", e);
        }
    }
}
