import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

public final class TextWorker {
    private static final String SPLITTER = "\\s|,|!|\\.|\"|;|\\?|:|\\]|\\[|}|\\{|\n|\t|\r|»|«|%|<|>|\\(|\\)|©|/|\\d|=";
    private static final String FILTER = "[^—\\-–-]+";

    private TextWorker() {
    }

    public static void splitAndPrintText(LinkedList<String> linesAccum) {
        HashMap<String, Integer> wordsCounter = splitText(linesAccum);
        sortAndPrintText(wordsCounter);
    }

    private static HashMap<String, Integer> splitText(LinkedList<String> linesAccum) {
        HashMap<String, Integer> countOfWords = new HashMap<>();
        for (String line : linesAccum) {
            String[] words = line.split(SPLITTER);
            for (String word : words) {
                if (Pattern.matches(FILTER, word) && !word.isEmpty()) {
                    word = word.toLowerCase();
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
