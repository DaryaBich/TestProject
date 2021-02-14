import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class TextWorker {
    private static final String regexp = "\\s|,|!|\\.|\"|;|\\?|:|\\]|\\[|}|\\{|\n|\t|\r|»|«|\\d|%|<|>|\\(|\\)|©";

    public static void splitAndPrintText(LinkedList<String> stripesAccumulatorText) {
        HashMap<String, Integer> wordsCount = TextWorker.splitText(stripesAccumulatorText);
        TextWorker.sortAndPrintText(wordsCount);
    }

    private static HashMap<String, Integer> splitText(LinkedList<String> stripes) {
        HashMap<String, Integer> countOfWords = new HashMap<>();
        for (String stripe : stripes) {
            String[] words = stripe.split(regexp);
            for (String word : words) {
                word = word.toLowerCase().trim();
                if (!word.equals("")) {
                    if (!word.equals("-")) {
                        int count = countOfWords.containsKey(word) ? countOfWords.get(word) + 1 : 1;
                        countOfWords.put(word, count);
                    }
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
