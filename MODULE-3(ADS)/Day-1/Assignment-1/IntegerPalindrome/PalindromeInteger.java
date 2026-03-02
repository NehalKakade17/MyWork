import java.util.Scanner;

public class PalindromeInteger {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = sc.nextInt();

        if (isPalindrome(number)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        sc.close();
    }
    public static boolean isPalindrome(int number) {
        if (number < 0 || (number % 10 == 0 && number != 0)) {
            return false;
        }

        return checkPalindrome(number, number);
    }
    private static boolean checkPalindrome(int cnumber, int original) {
        if (cnumber == 0) {
            return true; 
        }
        int reversed = 0;
	int temp = cnumber;
        while (temp != 0) {
            reversed = reversed * 10 + temp % 10;
            temp /= 10;
        }
        return (original == reversed);
    }
}
