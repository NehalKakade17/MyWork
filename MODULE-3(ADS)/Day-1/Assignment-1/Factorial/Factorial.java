import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long fact = factorial(num);
            System.out.println(fact);
        }

        sc.close();
    }
    public static long factorial(int n) {
        if (n == 0 || n == 1) { 
            return 1;
        }
        return n * factorial(n - 1);
    }
}
