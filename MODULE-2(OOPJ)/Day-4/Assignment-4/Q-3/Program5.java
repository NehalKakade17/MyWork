package assign4;

public class Program5 {

	public static void main(String[] args) {
		BMITracker bt = null;
		while(true) {
			BMITrackerUtil.menuList();
			int choice = BMITrackerUtil.sc.nextInt();
			switch (choice) {
			case 1:
				bt = BMITrackerUtil.acceptRecord();
				break;
			case 2:
				if(bt != null) {
					BMITrackerUtil.printRecord(bt);
				}
				else {
					System.out.println("Please first enter details!");
				}
				break;
			case 3:
				System.out.println("GoodBye!");
				BMITrackerUtil.sc.close();
				return;
			default:
				System.out.println("Invalid Choice!");
				break;
			}
				
		}

	}

}
