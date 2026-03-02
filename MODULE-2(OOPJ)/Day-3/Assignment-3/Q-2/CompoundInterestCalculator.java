package assign.pending;
import java.util.Scanner;

public class CompoundInterestCalculator {
	static Scanner sc = new Scanner(System.in);
    private double principal;
    private double annualInterestRate;
    private int numberOfCompounds;
    private int years;
    public void acceptRecord() {
        

        System.out.print("Enter the initial investment amount (in INR): ");
        principal = sc.nextDouble();

        System.out.print("Enter the annual interest rate (in %): ");
        annualInterestRate = sc.nextDouble();

        System.out.print("Enter the number of times the interest is compounded per year: ");
        numberOfCompounds = sc.nextInt();

        System.out.print("Enter the investment duration (in years): ");
        years = sc.nextInt();
    }
    public double calculateFutureValue() {
        double ratePerPeriod = annualInterestRate / 100 / numberOfCompounds;
        int totalPeriods = numberOfCompounds * years;

        return principal * Math.pow(1 + ratePerPeriod, totalPeriods);
    }
    public void printRecord() {
        double futureValue = calculateFutureValue();
        double totalInterest = futureValue - principal;

        System.out.printf("Future Value of the investment: ₹%.2f%n", futureValue);
        System.out.printf("Total Interest Earned: ₹%.2f%n", totalInterest);
    }
    public static void main(String[] args) {
        CompoundInterestCalculator calculator = new CompoundInterestCalculator();

        calculator.acceptRecord();
        calculator.printRecord();
        sc.close();
    }
}

