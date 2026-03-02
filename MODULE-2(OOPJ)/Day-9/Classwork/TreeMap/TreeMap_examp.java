package collectionsproblem;
import java.util.*;
public class TreeMap_examp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String,Integer> cook = new TreeMap<>();
		System.out.print("Enter size for cooking items: ");
		int size = sc.nextInt();
		sc.nextLine();
		System.out.println("cooking items:-");
		for(int i = 0;i<size;i++) {
			System.out.println("Enter cooking key: ");
			String item = sc.nextLine();
			System.out.println("Enter cooking value: ");
			int num = sc.nextInt();
			sc.nextLine();
			cook.put(item, num);
		}
		System.out.println("Enter item to check: ");
		String ch_item = sc.nextLine();
		System.out.println("Is" +ch_item+" Present?- "+cook.containsKey(ch_item));
		System.out.println("Enter count to check: ");
		int ch_num = sc.nextInt();
		System.out.println("Is" +ch_num+" Present?- "+cook.containsValue(ch_num));
		System.out.println("The cooking list is:");
		for(Map.Entry<String, Integer> entry : cook.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		sc.nextLine();
		System.out.print("Enter a key to remove: ");
        String removeKey = sc.nextLine();
        if (cook.containsKey(removeKey)) {
            cook.remove(removeKey);
            System.out.println("After removing '" + removeKey + "': " + cook);
        } else {
            System.out.println("Item '" + removeKey + "' not found.");
        }
        System.out.println("Size of TreeMap: " + cook.size());
		sc.close();

	}

}
