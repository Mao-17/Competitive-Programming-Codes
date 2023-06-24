import java.util.BitSet;
import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of test cases
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            // Get the size of the input numbers
            int n = scanner.nextInt();

            // Create a bit vector to store the unique elements
            BitSet bitVector = new BitSet(n);

            // Iterate over the array and set the corresponding bit in the bit vector
            for (int j = 0; j < n; j++) {
                int element = scanner.nextInt();
                if (!bitVector.get(element)) {
                    bitVector.set(element);
                }
            }

            // Count the number of bits that are set in the bit vector
            int numUniqueElements = bitVector.cardinality();

            // Print the number of unique elements
            System.out.println(numUniqueElements);
        }
    }
}
