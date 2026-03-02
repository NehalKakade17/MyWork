package assign2;
import java.util.*;
public class LeapYear {

	public static void main(String[] args) {
		System.out.println("Enter a year:");
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		if(year%400==0) {
			System.out.println(year+ " is a leap year");
		}
		else if(year%400==0) {
			System.out.println(year+ " is not a leap year");
		}
		else if(year%4==0) {
			System.out.println(year+ " is a leap year");
		}
		else {
			System.out.println(year+ " is not a leap year");
		}

	}

}
