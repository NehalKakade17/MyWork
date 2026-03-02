package assign4;
import java.util.Scanner;

public class LoanAmortizationCalculatorUtil {
    public static Scanner sc = new Scanner(System.in);

    public static LoanAmCal acceptRecord() {
        System.out.print("Enter the loan principal amount (₹): ");
        double principal = sc.nextDouble();
        
        System.out.print("Enter the annual interest rate (in %): ");
        double annualIntR = sc.nextDouble();
        
        System.out.print("Enter the loan term (in years): ");
        int loanT = sc.nextInt();
        
        return new LoanAmCal(principal, annualIntR, loanT);
    }

    public static void printRecord(LoanAmCal calculator) {
        System.out.println("\nLoan Details:");
        System.out.println(calculator);
        System.out.printf("Monthly Payment: ₹%.2f\n", calculator.calculateMonthlyPayment());
        System.out.printf("Total Amount Paid: ₹%.2f\n", calculator.calculateTotalAmountPaid());
    }

    public static void menuList() {
        System.out.println("\nMenu:");
        System.out.println("1. Enter Loan Details");
        System.out.println("2. Display Loan Information");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }
}

