import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DivisiblePairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the values of a and b
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        // Precompute the GCD of a and b
        int gcd = findGCD(a, b);

        // Precompute the divisors of the GCD
        Set<Integer> divisors = findDivisors(gcd);

        // Read the number of queries
        int n = scanner.nextInt();

        // Process each query
        for (int i = 0; i < n; i++) {
            int li = scanner.nextInt();
            int ri = scanner.nextInt();

            // Find the greatest divisor between li and ri that divides both a and b
            int di = findGreatestDivisor(divisors, li, ri);

            System.out.println(di);
        }

        scanner.close();
    }

    // Function to find the greatest common divisor (GCD) using Euclidean algorithm
    private static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }

        return findGCD(b, a % b);
    }

    // Function to find all divisors of a number
    private static Set<Integer> findDivisors(int number) {
        Set<Integer> divisors = new HashSet<>();

        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                divisors.add(i);
                divisors.add(number / i);
            }
        }

        return divisors;
    }

    // Function to find the greatest integer between li and ri that divides both a and b
    private static int findGreatestDivisor(Set<Integer> divisors, int li, int ri) {
        int max = - 1;
        for (int divisor : divisors) {
            if (divisor >= li && divisor <= ri) {
                if(max<divisor) max = divisor;
            }
        }

        return max; // No divisor found between li and ri
    }
}
