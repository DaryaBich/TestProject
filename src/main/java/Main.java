import java.util.Scanner;

@lombok.extern.slf4j.Slf4j
public class Main {

    public static void main(String[] args) {
        System.out.println("Input url: ");
        Scanner in = new Scanner(System.in);
        String url = in.next();
        HtmlWordStatistic.getAndPrintWordStatistic(url);
    }
}
