package assign.pending;
import java.util.Scanner;

public class LoanAmortizationCalculator {
	static Scanner sc = new Scanner(System.in);
    private double principal;
    private double annualInterestRate;
    private int loanTerm;
    public void acceptRecord() {
        

        System.out.print("Enter the principal amount (loan amount) in INR: ");
        principal = sc.nextDouble();

        System.out.print("Enter the annual interest rate (in %): ");
        annualInterestRate = sc.nextDouble();

        System.out.print("Enter the loan term (in years): ");
        loanTerm = sc.nextInt();
    }
    public double calculateMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 12 / 100;
        int numberOfMonths = loanTerm * 12;

        if (monthlyInterestRate == 0) {
            return principal / numberOfMonths;
        }

        double numerator = monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths);
        double denominator = Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1;
        return principal * (numerator / denominator);
    }
    public void printRecord() {
        double monthlyPayment = calculateMonthlyPayment();
        double totalAmountPaid = monthlyPayment * loanTerm * 12;

        System.out.printf("Monthly Payment: ₹%.2f%n", monthlyPayment);
        System.out.printf("Total Amount Paid over the life of the loan: ₹%.2f%n", totalAmountPaid);
    }
    public static void main(String[] args) {
        LoanAmortizationCalculator calculator = new LoanAmortizationCalculator();

        calculator.acceptRecord();
        calculator.printRecord();
        sc.close();
    }
}

