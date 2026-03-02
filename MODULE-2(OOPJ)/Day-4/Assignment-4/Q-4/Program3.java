package assign4;
public class Program3 {
    public static void main(String[] args) {
        DiscCal calculator = null;
        while (true) {
            DiscCalcUtil.menuList();
            int option = DiscCalcUtil.sc.nextInt();
            switch (option) {
                case 1:
                    calculator = DiscCalcUtil.acceptRecord();
                    break;
                case 2:
                    if (calculator != null) {
                        DiscCalcUtil.printRecord(calculator);
                    } else {
                        System.out.println("Please enter discount details first.");
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

