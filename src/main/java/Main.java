import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ввод
        System.out.println("Input url: ");
        Scanner in = new Scanner(System.in);
        String url = in.next();

        HtmlWordStatistic htmlWordStatistic = new HtmlWordStatistic(url);
        htmlWordStatistic.printWordStatistic();
    }
}
