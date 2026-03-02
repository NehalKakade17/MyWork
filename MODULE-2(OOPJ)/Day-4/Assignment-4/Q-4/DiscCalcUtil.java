package assign4;
import java.util.Scanner;

public class DiscCalcUtil {
    public static Scanner sc = new Scanner(System.in);
    public static DiscCal acceptRecord() {
        System.out.print("Enter the original price of the item: ");
        double originalPrice = sc.nextDouble();
        
        System.out.print("Enter the discount percentage: ");
        double discountRate = sc.nextDouble();
        
        return new DiscCal(originalPrice, discountRate);
    }
    public static void printRecord(DiscCal calculator) {
        System.out.println("\nDiscount Details:");
        System.out.println(calculator);
        System.out.printf("Discount Amount: %.2f\n", calculator.calculateDiscountAmount());
        System.out.printf("Final Price: %.2f\n", calculator.calculateFinalPrice());
    }
    public static void menuList() {
        System.out.println("\nMenu:");
        System.out.println("1. Enter Discount Details");
        System.out.println("2. Display Discount Information");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }
}

