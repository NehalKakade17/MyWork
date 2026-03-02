import java.util.Scanner;

public class DiscountCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total purchase amount (in Rs): ");
        double totalPurchase = scanner.nextDouble();
        System.out.print("Do you have a membership card? (yes/no): ");
        String hasMembershipCard = scanner.next().trim().toLowerCase();
        double discount = 0.0;
        if (totalPurchase >= 1000) {
            discount = 20; 
        } else if (totalPurchase >= 500) {
            discount = 10; 
        } else {
            discount = 5; 
        }
         if (hasMembershipCard.equals("yes")) {
            discount += 5; 
        }
        double discountAmount = totalPurchase * (discount / 100);
        double finalAmount = totalPurchase - discountAmount;
        System.out.printf("Original amount: Rs. %.2f%n", totalPurchase);
        System.out.printf("Discount applied: %.2f%%%n", discount);
        System.out.printf("Discount amount: Rs. %.2f%n", discountAmount);
        System.out.printf("Final amount after discount: Rs. %.2f%n", finalAmount);
        scanner.close();
    }
}