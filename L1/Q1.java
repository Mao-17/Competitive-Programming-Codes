import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CP1Course {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // total number of submissions
        scanner.nextLine();  // consume the newline character
        
        Map<String, Integer> studentPoints = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String studentName = parts[0];
            int rating = Integer.parseInt(parts[1]);
            
            int points = calculatePoints(rating);
            
            // Add the points to the existing total for the student
            studentPoints.put(studentName, studentPoints.getOrDefault(studentName, 0) + points);
        }
        
        int maxPoints = 0;
        
        // Find the maximum points scored by any student
        for (int points : studentPoints.values()) {
            maxPoints = Math.max(maxPoints, points);
        }
        
        System.out.println(maxPoints);
    }
    
    private static int calculatePoints(int rating) {
        int baseRating = 1100;
        int pointsPerInterval = 0;
        
        while (baseRating <= rating) {
            pointsPerInterval++;
            baseRating += 199;
        }
        
        return pointsPerInterval;  // Adjust for zero-based indexing
    }
}
