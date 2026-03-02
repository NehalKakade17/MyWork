import java.util.Scanner;

public class LeapYearChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        if (isLeapYear(year)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        sc.close();
    }
    public static boolean isLeapYear(int year) {
        if (year < 0) {
            return false;
        }
        return checkLeapYear(year);
    }
    private static boolean checkLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }
}
