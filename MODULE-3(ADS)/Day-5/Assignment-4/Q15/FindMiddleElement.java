import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class FindMiddleElement {

    // Method to find the middle node of a linked list
    public static ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Move fast pointer two steps and slow pointer one step
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow by one
            fast = fast.next.next;     // Move fast by two
        }

        return slow; // Slow is now at the middle node
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

        // Create linked list
        System.out.println("Create Linked List:");
        ListNode head = createLinkedList(scanner);

        // Find the middle node
        ListNode middleNode = findMiddle(head);
        if (middleNode != null) {
            System.out.println("The middle element is: " + middleNode.val);
        } else {
            System.out.println("The list is empty.");
        }

        scanner.close();
    }
}
