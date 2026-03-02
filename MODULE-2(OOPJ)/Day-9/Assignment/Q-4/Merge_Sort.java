package collectionsproblem;
import java.util.*;
public class Merge_Sort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the first sorted list: ");
        int size1 = scanner.nextInt();
        List<Integer> list1 = new ArrayList<>();
        System.out.println("Enter the elements of the first sorted list:");
        for (int i = 0; i < size1; i++) {
            list1.add(scanner.nextInt());
        }
        
        System.out.print("Enter the number of elements in the second sorted list: ");
        int size2 = scanner.nextInt();
        List<Integer> list2 = new ArrayList<>();
        System.out.println("Enter the elements of the second sorted list:");
        for (int i = 0; i < size2; i++) {
            list2.add(scanner.nextInt());
        }
        Collections.sort(list1);
        Collections.sort(list2);
        List<Integer> mergedList = mergeSortedLists(list1, list2);
        System.out.println("Merged sorted list: " + mergedList);
        scanner.close();
    }

    private static List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }
        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;

	}

}
