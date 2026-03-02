package collectionsproblem;
import java.util.*;
public class ArrayDeque_examp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<String> hero = new ArrayDeque<>();
		System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            String element = sc.nextLine();
            hero.add(element); 
        }
        System.out.println("Current elements in the deque: " + hero);

        System.out.println("First element (peek): " + hero.peekFirst());
        System.out.println("Last element (peek): " + hero.peekLast());
        System.out.print("Enter the number of elements to remove from the front: ");
        int removeCount = sc.nextInt();

        for (int i = 0; i < removeCount; i++) {
            String removedElement = hero.pollFirst(); 
            System.out.println("Removed: " + removedElement);
        }
        System.out.println("Elements after removal: " + hero);
        System.out.print("Enter an element to add to the front: ");
        String frontElement = sc.next();
        hero.addFirst(frontElement); 
        System.out.println("Deque after adding to front: " + hero);
        hero.clear();
        System.out.println("Deque after clearing: " + hero);
        sc.close();
    }


}


