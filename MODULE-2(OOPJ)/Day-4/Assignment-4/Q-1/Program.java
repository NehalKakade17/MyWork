package assign4;
public class Program {
    public static void main(String[] args) {
        LoanAmCal calculator = null;
        while (true) {
            LoanAmortizationCalculatorUtil.menuList();
            int option = LoanAmortizationCalculatorUtil.sc.nextInt();
            switch (option) {
                case 1:
                    calculator = LoanAmortizationCalculatorUtil.acceptRecord();
                    break;
                case 2:
                    if (calculator != null) {
                        LoanAmortizationCalculatorUtil.printRecord(calculator);
                    } else {
                        System.out.println("Please enter loan details first.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

