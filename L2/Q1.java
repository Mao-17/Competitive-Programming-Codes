import java.util.BitSet;
import java.util.Scanner;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        long result;

        // same sign
        if (x == 0 && y == 0)
            result = 0;

        else if ((x > 0 && y > 0 && y >= x) || (x < 0 && y < 0 && y >= x)) {
            result = Math.abs(x - y); // Modify the modulus value as per your requirement
        } else if ((x > 0 && y > 0 && x > y) || (x < 0 && y < 0 && x > y)) {
            result = Math.abs(x - y) + 2; // Modify the modulus value as per your requirement
        }

        // x pos y -ve
        else if (x > 0 && y < 0) {
            result = Math.abs(x + y) + 1; // Modify the modulus value as per your requirement
        }
        // x neg y pos
        else if (x < 0 && y > 0) {
            result = Math.abs(x + y) + 1; // Modify the modulus value as per your requirement
        }
        // y = 0 x pos
        else if (y == 0 && x > 0)
            result = Math.abs(x) + 1;

        // y = 0 x neg
        else if (y == 0 && x < 0)
            result = Math.abs(x);

        // x = 0 y neg
        else if (x == 0 && y < 0)
            result = Math.abs(y) + 1;

        // x = 0 y pos
        else if (x == 0 && y > 0)
            result = Math.abs(y);

        else {
            result = Math.abs(x - y);
        }
        System.out.println(result);

        scanner.close();
    }
}