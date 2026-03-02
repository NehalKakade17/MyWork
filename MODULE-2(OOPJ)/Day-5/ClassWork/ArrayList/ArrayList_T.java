package selfstudy;
import java.util.*;
public class ArrayList_T {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<?> list = new ArrayList<>();
		System.out.println("Select from below-");
		System.out.println("1.Add Integer");
		System.out.println("2.Add String");
		System.out.println("3.Add Decimal");
		System.out.println("4.Display List");
		System.out.println("5.Exit");
		while(true) {
			System.out.print("Enter choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				System.out.print("Enter Integer: ");
				Integer val = sc.nextInt();
				sc.nextLine();
				addEle((ArrayList<Object>)list,val);
				break;
			case 2:
				System.out.print("Enter String: ");
				String str = sc.nextLine();
				addEle((ArrayList<Object>)list,str);
				break;
			case 3:
				System.out.print("Enter Decimal: ");
				Double dval = sc.nextDouble();
				addEle((ArrayList<Object>)list,dval);
				break;
			case 4:
				System.out.println("List has:-");
				displayRecord(list);
				break;
			case 5:
				System.out.println("Exit....");
				sc.close();
				return;
			default:
				System.out.println("Invalid Choice!!");
			}
		}
	}
	public static <T> void addEle(ArrayList<T>list,T element){
		list.add(element);
	}
	public static void displayRecord(List<?> list) {
		for(Object obj : list) {
			System.out.println(obj);
		}
	}

}
