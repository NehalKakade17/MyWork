package assign4;
import java.util.*;
public class BMITrackerUtil {
	public static Scanner sc = new Scanner(System.in);
	public static BMITracker acceptRecord() {
		System.out.print("Enter your weight in kg: ");
		double weight = sc.nextDouble();
		System.out.print("Enter your height in meters: ");
		double height = sc.nextDouble();
		BMITracker bt = new BMITracker(weight,height);
		bt.setWeight(weight);
		bt.setHeight(height);
		return bt;
	}
	public static void printRecord(BMITracker bt) {
		System.out.println("Your weight is: " + bt.getWeight() + " kg");
		System.out.println("Your height is: " + bt.getHeight() + " meters");
		bt.calBMI();
		bt.displayBMI();
		
	}
	public static void menuList() {
		System.out.println("Choose one option:-");
		System.out.println("1.Enter details to calculate BMI: ");
		System.out.println("2.Display deyails: ");
		System.out.println("3.Exit");
		System.out.print("Enter choice:");
	}
	
	

}
