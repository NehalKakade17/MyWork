package assign4;
public class Program4 {
    public static void main(String[] args) {
        TolBRevMan manager = null;
        while (true) {
            TolBRevManUtil.menuList();
            int option = TolBRevManUtil.sc.nextInt();
            switch (option) {
                case 1:
                    manager = TolBRevManUtil.acceptRecord();
                    break;
                case 2:
                    if (manager != null) {
                        TolBRevManUtil.printRecord(manager);
                    } else {
                        System.out.println("Please enter toll rates and vehicle numbers first.");
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

