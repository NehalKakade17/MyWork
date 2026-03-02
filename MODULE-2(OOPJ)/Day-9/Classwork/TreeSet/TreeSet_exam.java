package collectionsproblem;
import java.util.*;
public class TreeSet_exam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeSet<Integer> count = new TreeSet<>();
		System.out.print("Enter size: ");
		int size = sc.nextInt();
		System.out.print("Enter elements: ");
		for(int i = 0;i<size;i++) {
			int n = sc.nextInt();
			count.add(n);
		}
		int s = count.size();
		System.out.println("Size: "+s);
		System.out.println("Check element: ");
		int ch = sc.nextInt();
		System.out.println("Is "+ch+" present: "+count.contains(ch));
		System.out.println("Higher value than 10: "+count.higher(10));
		System.out.println("Lower value than 10: "+count.lower(10));
		for(int ele : count) {
			System.out.println(ele);
		}
		sc.close();
	}
}
