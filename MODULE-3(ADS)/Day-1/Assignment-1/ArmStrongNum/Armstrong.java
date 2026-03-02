import java.util.Scanner;

public class Armstrong {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int digit = String.valueOf(num).length();

        if (isArmstrong(num, digit)) {
            System.out.println(num + " is an Armstrong number.");
        } else {
            System.out.println(num + " is not an Armstrong number.");
        }

        sc.close();
    }
    public static boolean isArmstrong(int num, int dig) {
        return checkArmstrong(num, num, dig,0);
    }
    private static boolean checkArmstrong(int original, int current, int dig,int sum) {
        if (current == 0) {
            return sum == original;
        }

        int lastDigit = current % 10;
        sum += Math.pow(lastDigit, dig);
        return checkArmstrong(original, current / 10, dig,sum);
    }
}
