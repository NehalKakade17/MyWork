package collectionsproblem;
import java.util.*;
public class LinkedList_exam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<String> vegies = new LinkedList<>();
		System.out.print("Enter size for array: ");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter vegies: ");
		for(int i=0;i<n;i++) {
			String veg = sc.nextLine();
			vegies.add(veg);
		}
		System.out.print("Enter index to show: ");
		int index = sc.nextInt();
		sc.nextLine();
		String veg_name = vegies.get(index);
		System.out.println("Vegetables: "+veg_name);
		System.out.println("First element is: "+vegies.getFirst());
		System.out.println("Last element is: "+vegies.getLast());
		for(String all : vegies) {
			System.out.println(all);
		}
		System.out.println("Enter element to remove: ");
		String rem = sc.nextLine();
		vegies.remove(rem);
		System.out.println(vegies);
		
		vegies.clear();
		System.out.println("Size: "+vegies.size());
		sc.close();
	}

}
