import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTestCases = scanner.nextInt();
        for (int i = 0; i < numTestCases; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int x = scanner.nextInt();
            List<Integer> numbers = new ArrayList<>();

            if ((n == 1 && x == 1) || (n % 2 != 0 && k <= 2 && x == 1)) {
                System.out.println("NO");
            }

            else if (x != 1 && n >= 1 && k > 1) {
                System.out.println("YES");
                if (x != 1) {
                    System.out.println(n);
                }
                for (int j = 0; j < n; j++) {
                    System.out.print(1 + " ");
                }
                System.out.println();
            } else if (x == 1 && n % 2 == 0 && k >= 2) {
                System.out.println("YES");
                System.out.println(n / 2);
                for (int j = 0; j < n / 2; j++) {
                    System.out.print(2 + " ");
                }
                System.out.println();
            } else if (x == 1 && n % 2 != 0 && k == 2) {
                System.out.println("NO");
            } else if (x == 1 && n % 2 != 0 && k > 2) {
                System.out.println("YES");
                System.out.println(n / 2);
                for (int j = 0; j < n / 2 - 1; j++) {
                    System.out.print(2 + " ");
                }
                System.out.print(3 + " ");
                System.out.println();
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}
