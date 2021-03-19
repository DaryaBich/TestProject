import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.HashSet;
import java.util.LinkedList;

public final class SAXStripesAccum extends DefaultHandler {
    public static final SAXStripesAccum INSTANCE = new SAXStripesAccum();
    
    private final HashSet<String> tags;
    private final LinkedList<String> text;
    private String currentElement;

    private SAXStripesAccum() {
        text = new LinkedList<>();
        tags = createTagsSet();
    }

    public LinkedList<String> getText() {
        return text;
    }

    @Override
    public void startDocument() throws SAXException {
        text = new LinkedList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String qNameReplace = qName.replace("/", "").trim();
        if (qNameReplace.equalsIgnoreCase("a") && attributes.getValue("title") != null) {
            text.add(attributes.getValue("title"));
        }
        if (qNameReplace.equalsIgnoreCase("img") && attributes.getValue("alt") != null) {
            text.add(attributes.getValue("alt"));
        }
        currentElement = qNameReplace;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (tags.contains(currentElement)) {
            String newStr = new String(ch, start, length);
            if (!(newStr.equals("") || newStr.equals("!>"))) {
                text.add(newStr);
            }
        }
    }

    private HashSet<String> createTagsSet() {
        HashSet<String> tagsSet = new HashSet<>();
        tagsSet.add("title");
        tagsSet.add("button");
        tagsSet.add("a");
        tagsSet.add("caption");
        tagsSet.add("option");
        tagsSet.add("dfn");
        tagsSet.add("dl");
        tagsSet.add("dt");
        tagsSet.add("figcaption");
        tagsSet.add("h1");
        tagsSet.add("h2");
        tagsSet.add("h3");
        tagsSet.add("h4");
        tagsSet.add("h5");
        tagsSet.add("h6");
        tagsSet.add("label");
        tagsSet.add("legend");
        tagsSet.add("pre");
        tagsSet.add("q");
        tagsSet.add("rb");
        tagsSet.add("rt");
        tagsSet.add("rtc");
        tagsSet.add("rp");
        tagsSet.add("s");
        tagsSet.add("small");
        tagsSet.add("span");
        tagsSet.add("summary");
        tagsSet.add("p");
        tagsSet.add("div");
        return tagsSet;
    }
}

