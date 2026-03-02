package assign2;
import java.util.*;
public class LeapYearSw {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter a year:");
        int year = sc.nextInt();
        int status = (year % 400 == 0) ? 1 :
                     (year % 100 == 0) ? 2 :
                     (year % 4 == 0) ? 3 : 4;

        switch (status) {
            case 1:
                System.out.println(year + " is a leap year");
                break;
            case 2:
            case 4:
                System.out.println(year + " is not a leap year");
                break;
            case 3:
                System.out.println(year + " is a leap year");
                break;
            default:
                System.out.println("Invalid input");
        }
    }

	

}
