import java.util.Scanner;
import java.util.TreeSet;

public class BookFair {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n, m, and the initial book prices
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        TreeSet<Integer> bookPrices = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            int price = scanner.nextInt();
            bookPrices.add(price);
        }

        int totalIceCreamCost = 0;

        // Process each day
        for (int day = 1; day <= n; day++) {
            // Read the number of books added and the money received on the current day
            int numBooksAdded = scanner.nextInt();
            int moneyReceived = scanner.nextInt();

            // Read the prices of the books added on the current day
            for (int i = 0; i < numBooksAdded; i++) {
                int bookPrice = scanner.nextInt();
                bookPrices.add(bookPrice);
            }

            Integer max = bookPrices.floor(moneyReceived);

            // If there is a book that Athena can buy, subtract its price from the received money
            // and add the remaining money to the totalIceCreamCost
            if (max != null) {
                moneyReceived -= max;
                totalIceCreamCost += moneyReceived;
                bookPrices.remove(max);
            } else {
                totalIceCreamCost += moneyReceived;
            }
            //String setAsString = bookPrices.toString();
        //System.out.println(setAsString);
        //System.out.println(totalIceCreamCost);
        }

        // Print the total money spent on ice cream
        System.out.println(totalIceCreamCost);
    }
}
