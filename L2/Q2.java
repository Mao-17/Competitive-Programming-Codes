import java.util.Scanner;
import java.util.PriorityQueue;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            long totalCost = 0;
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (b > a) {
                    totalCost += a;
                    pq.add(b - a);
                } else {
                    totalCost += b;
                    k--;
                }
            }
            while (k-- > 0) {
                totalCost += pq.poll();
            }
            System.out.println(totalCost);
        }
    }
}
