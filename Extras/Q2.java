import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTestCases = scanner.nextInt();
        for (int i = 0; i < numTestCases; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int x3 = scanner.nextInt();
            int y3 = scanner.nextInt();
            int ans = 1;
            if (x1 >= x2 && x1 >= x3) {
                ans += Math.min(x1 - x2, x1 - x3);
            } else if (x1 <= x2 && x1 <= x3) {
                ans += Math.min(x2 - x1, x3 - x1);
            }
            if (y1 >= y2 && y1 >= y3) {
                ans += Math.min(y1 - y2, y1 - y3);
            } else if (y1 <= y2 && y1 <= y3) {
                ans += Math.min(y2 - y1, y3 - y1);
            }
            System.out.println(ans);
        }

        scanner.close();
    }
}
