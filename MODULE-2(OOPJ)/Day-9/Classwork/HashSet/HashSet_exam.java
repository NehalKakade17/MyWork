package collectionsproblem;
import java.util.*;
public class HashSet_exam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<String> fruits = new HashSet<>();
		System.out.print("Enter size for set:");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter fruits:");
		for(int i =0;i<n;i++) {
			String f = sc.nextLine();
			fruits.add(f);
		}
		System.out.println("Size : "+fruits.size());
		System.out.println("Enter fruit to check:");
		String chk = sc.nextLine();
		System.out.print("Is "+chk+" present:- "+fruits.contains(chk));
		sc.nextLine();
		Iterator<String> it = fruits.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		sc.close();

	}

}
