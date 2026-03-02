package collectionsproblem;
import java.util.*;
public class Array_Example {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> names = new ArrayList<>();
		System.out.print("Enter size for list:");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter names:");
		for(int i = 0;i<n;i++) {
			String name = sc.nextLine();
			names.add(name);
		}
		System.out.println("Enter index to show corresponding name:");
		int index = sc.nextInt();
		sc.nextLine();
		String ind_name = names.get(index);
		System.out.println("Name: "+ind_name);
		System.out.println("Enter index:");
		int ind = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter new name:");
		String new_name = sc.nextLine();
		names.set(ind, new_name);
		System.out.println(names);
		
		System.out.println("Enter name to remove:");
		String rem = sc.nextLine();
		names.remove(rem);
		int size = names.size();
		System.out.println("Size: "+size);
		System.out.println("Enter name to check: ");
		String ck = sc.nextLine();
		boolean bk = names.contains(ck);
		System.out.println("Is "+ck+" present:- "+bk);
		
		sc.close();
	}
	

}
