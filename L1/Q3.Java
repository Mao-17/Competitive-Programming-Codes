import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Map<String, Integer> scores = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String studentName = input[0];
            int rating = Integer.parseInt(input[1]);

            int points = getPoints(rating);
            scores.put(studentName, scores.getOrDefault(studentName, 0) + points);
        }

        int maxScore = 0;
        for (int score : scores.values()) {
            maxScore = Math.max(maxScore, score);
        }

        System.out.println(maxScore);
    }

    private static int getPoints(int rating) {
        if(rating<1100) return 0;
        int baseRating = 1100;
        int basePoints = 1;
        int pointsPerIncrease = 200;

        int difference = rating - baseRating;
        if (difference < 0) {
            return 0;
        } else {
            return (difference / pointsPerIncrease + 1) * basePoints;
        }
    }
}

