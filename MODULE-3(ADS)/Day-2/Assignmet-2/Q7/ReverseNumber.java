import java.util.Scanner;

public class ReverseNumber {
    public static int reverse(int num) {
        if (num == 0) {
            return 0;
        }
        int reversed = reverse(num / 10);
        int numDigits = (int) Math.log10(Math.abs(num));
        return (reversed + (num % 10) * (int) Math.pow(10, numDigits));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int result = reverse(Math.abs(number)); 
        if (number < 0) {
            result = -result;
        }
        System.out.println("Reversed number: " + result);
        sc.close();
    }
}
