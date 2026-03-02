package collectionsproblem;
import java.util.*;
public class List_duplicate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		System.out.print("Enter size: ");
		int size = sc.nextInt();
		System.out.println("For list- ");
		for(int i =0;i<size;i++) {
			System.out.println("Enter "+(i+1)+" element: ");
			int ele = sc.nextInt();
			list.add(ele);
		}
		List<Integer> result = duplicate(list);
		System.out.println("Duplicate list: "+result);
		sc.close();
	}
	public static List<Integer> duplicate(List<Integer> numbers) {
		List<Integer> duplicates = new ArrayList<>();
        List<Integer> checked = new ArrayList<>();
        for (Integer number : numbers) {
            if (checked.contains(number) && !duplicates.contains(number)) {
                duplicates.add(number); 
            } else {
                checked.add(number);
            }
        }
        return duplicates;

	}

}
