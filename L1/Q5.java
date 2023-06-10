import java.util.Scanner;

public class GiftShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] values = new int[n];
        int[] costs = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            costs[i] = scanner.nextInt();
        }

        long minCost = findMinimumCost(values, costs, k);
        System.out.println(minCost);
    }

    private static long findMinimumCost(int[] values, int[] costs, int k) {
        int n = values.length;
        long minCost = Long.MAX_VALUE;
        long valueSum = 0;
        long costSum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            valueSum += values[right];
            costSum += costs[right];

            while (valueSum >= k) {
                if (costSum < minCost) {
                    minCost = costSum;
                }
                valueSum -= values[left];
                costSum -= costs[left];
                left++;
            }
        }

        if (minCost == Long.MAX_VALUE) {
            return -1;
        } else {
            return minCost;
        }
    }
}
