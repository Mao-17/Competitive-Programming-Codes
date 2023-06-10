import java.util.Scanner;

public class StringOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        String encodedString = scanner.next();

        char[] answer = new char[n];

        int left = 0;
        int right = n - 1;
        for (int j = n - 1; j >= 0; j--) {
            char lastCharacter = encodedString.charAt(j);
            if ((n - 1 - j) % 2 == 0) {
                answer[right--] = lastCharacter;
            } else {
                answer[left++] = lastCharacter;
            }
        }

        System.out.println(new String(answer));
    }
}
