import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if(isPrime(num, 2)) {
            System.out.println("true");
        }else {
            System.out.println("false");
        }

        sc.close();
    }
    public static boolean isPrime(int num, int divisor){
        if(num <= 1) {
            return false; 
        }
        if(divisor * divisor > num) {
            return true;
        }
        if(num % divisor == 0) {
            return false; 
        }
        return isPrime(num, divisor + 1); //recursive call upto square root of entered number.For example 11 -> square root is 3.something so executes upto 3.
    }
}
