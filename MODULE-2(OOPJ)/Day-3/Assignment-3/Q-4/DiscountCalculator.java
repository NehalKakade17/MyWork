package assign.pending;
import java.util.Scanner;

public class DiscountCalculator {
	static Scanner sc = new Scanner(System.in);
    private double originalPrice;
    private double discountRate;
    public void acceptRecord() {
        System.out.print("Enter the original price of the item (in INR): ");
        originalPrice = sc.nextDouble();

        System.out.print("Enter the discount percentage: ");
        discountRate = sc.nextDouble();
    }
    public void calculateDiscount() {
        double discountAmount = originalPrice * (discountRate / 100);
        double finalPrice = originalPrice - discountAmount;
        printRecord(discountAmount, finalPrice);
    }
    public void printRecord(double discountAmount, double finalPrice) {
        System.out.printf("Discount Amount: ₹%.2f%n", discountAmount);
        System.out.printf("Final Price: ₹%.2f%n", finalPrice);
    }
    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();

        calculator.acceptRecord();
        calculator.calculateDiscount();
        sc.close();
    }
}

