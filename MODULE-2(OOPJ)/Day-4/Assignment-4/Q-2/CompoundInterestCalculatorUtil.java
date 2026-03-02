package assign4;
import java.util.Scanner;

public class CompoundInterestCalculatorUtil {
    public static Scanner sc = new Scanner(System.in);
    public static CompoundIntCal acceptRecord() {
        System.out.print("Enter the initial investment amount (₹): ");
        double principal = sc.nextDouble();
        
        System.out.print("Enter the annual interest rate (in %): ");
        double annualIntR = sc.nextDouble();
        
        System.out.print("Enter the number of times interest is compounded per year: ");
        int numOfComp = sc.nextInt();
        
        System.out.print("Enter the investment duration (in years): ");
        int years = sc.nextInt();
        
        return new CompoundIntCal(principal, annualIntR, numOfComp, years);
    }
    public static void printRecord(CompoundIntCal calculator) {
        System.out.println("\nInvestment Details:");
        System.out.println(calculator);
        System.out.printf("Future Value: ₹%.2f\n", calculator.calculateFutureValue());
        System.out.printf("Total Interest Earned: ₹%.2f\n", calculator.calculateTotalInterest());
    }
    public static void menuList() {
        System.out.println("\nMenu:");
        System.out.println("1. Enter Investment Details");
        System.out.println("2. Display Investment Information");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }
}

