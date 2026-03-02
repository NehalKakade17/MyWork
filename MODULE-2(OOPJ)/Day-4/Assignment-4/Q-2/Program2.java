package assign4;
public class Program2 {
    public static void main(String[] args) {
        CompoundIntCal calculator = null;
        while (true) {
            CompoundInterestCalculatorUtil.menuList();
            int option = CompoundInterestCalculatorUtil.sc.nextInt();
            switch (option) {
                case 1:
                    calculator = CompoundInterestCalculatorUtil.acceptRecord();
                    break;
                case 2:
                    if (calculator != null) {
                        CompoundInterestCalculatorUtil.printRecord(calculator);
                    } else {
                        System.out.println("Please enter investment details first.");
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

