import java.util.LinkedList;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            char[] answer = new char[n];
            LinkedList<Integer> arr = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                arr.add(num);
                int s = arr.size() - 1;
                boolean check;
                if (arr.size() == 1)
                    check = true;
                else if (num <= arr.get(0) && num >= arr.get(arr.size() - 2)) {
                    check = true;
                } else {
                    check = checkRotation(arr);
                }
                if (check) {
                    answer[i] = '1';
                } else {
                    answer[i] = '0';
                    arr.remove(s);
                }
            }
            String finalString = new String(answer);
            System.out.println(finalString);
        }
        scanner.close();
    }

    public static boolean checkRotation(LinkedList<Integer> nums) {
        int n = nums.size();
        int ctr = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) > nums.get((i + 1) % n)) {
                ctr++;
            }
        }
        if (ctr > 1) {
            return false;
        }
        return true;
    }

}