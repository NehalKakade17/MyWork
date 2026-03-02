import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string to check if it's a palindrome: ");
        String input = scanner.nextLine();
        
        boolean isPalindrome = isPalindrome(input);
        
        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }

        scanner.close();
    }
    private static boolean isPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        return isPalindromeHelper(str, 0, str.length() - 1);
    }
    private static boolean isPalindromeHelper(String str, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (str.charAt(left) != str.charAt(right)) {
            return false; 
        }
        return isPalindromeHelper(str, left + 1, right - 1);
    }
}
