import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Input url: ");
        Scanner in = new Scanner(System.in);
        String url = in.next();

        HtmlWordStatistic statistic = new HtmlWordStatistic(url);
        statistic.getAndPrintWordStatistic();
    }
}
