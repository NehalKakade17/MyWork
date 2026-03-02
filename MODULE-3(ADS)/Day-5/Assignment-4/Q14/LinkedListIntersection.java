import java.util.HashSet;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListIntersection {

    // Method to find the first common element (intersection point) in two linked lists
    public static Integer findIntersectionValue(ListNode headA, ListNode headB) {
        HashSet<Integer> values = new HashSet<>();

        // Traverse the first list and store its values in a set
        ListNode currentA = headA;
        while (currentA != null) {
            values.add(currentA.val);
            currentA = currentA.next;
        }

        // Traverse the second list and check for common values
        ListNode currentB = headB;
        while (currentB != null) {
            if (values.contains(currentB.val)) {
                return currentB.val; // Return the first common value
            }
            currentB = currentB.next;
        }

        return null; // No intersection found
    }

    // Helper function to create a linked list from user input
    public static ListNode createLinkedList(Scanner scanner) {
        System.out.print("Enter the number of nodes: ");
        int n = scanner.nextInt();

        if (n == 0) return null;

        System.out.print("Enter the values for the linked list: ");
        ListNode head = new ListNode(scanner.nextInt());
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create first linked list
        System.out.println("Create Linked List A:");
        ListNode listA = createLinkedList(scanner);

        // Create second linked list
        System.out.println("Create Linked List B:");
        ListNode listB = createLinkedList(scanner);

        // Find the first common element (intersection value)
        Integer intersectionValue = findIntersectionValue(listA, listB);
        if (intersectionValue != null) {
            System.out.println("The first intersection value is: " + intersectionValue);
        } else {
            System.out.println("No intersection found.");
        }

        scanner.close();
    }
}
