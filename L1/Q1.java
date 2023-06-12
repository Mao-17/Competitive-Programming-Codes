import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Length of the array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt(); // Array elements
        }
        scanner.close();
        long result = 0;
        for(int i = 0; i<n; i++){
            result+=arr[i]-1;
        }
        System.out.println(result);
    }
}
