import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class TextWorker {
    private static final String SPLITTER = "\\s|,|!|\\.|\"|;|\\?|:|\\]|\\[|}|\\{|\n|\t|\r|»|«|\\d|%|<|>|\\(|\\)|©|/";
    
    private TextWorker(){}

    public static void splitAndPrintText(LinkedList<String> stripesAccumulatorText) {
        HashMap<String, Integer> wordsCounter = splitText(stripesAccumulatorText);
        sortAndPrintText(wordsCounter);
    }

    private static HashMap<String, Integer> splitText(LinkedList<String> stripes) {
        HashMap<String, Integer> countOfWords = new HashMap<>();
        for (String stripe : stripes) {
            String[] words = stripe.split(SPLITTER);
            for (String word : words) {
                word = word.toLowerCase().trim();
                if (!(word.equals("") || word.equals("—") || word.equals("-") || word.equals("–") || //это муть какая-то
                        word.startsWith("-"))) {
                    int count = countOfWords.containsKey(word) ? countOfWords.get(word) + 1 : 1;
                    countOfWords.put(word, count);
                }
            }
        }
        return countOfWords;
    }

    private static void sortAndPrintText(HashMap<String, Integer> wordsCount) {
        wordsCount
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
