import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RotateLinkedList {

    public static ListNode rotateRight(ListNode head, int k) {
        // Handle edge cases
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Determine the length of the list
        ListNode current = head;
        int length = 1;  // Start with 1 to count the head
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Connect the tail to the head to form a circular linked list
        current.next = head;

        // Step 2: Normalize k
        k = k % length;
        if (k == 0) {
            current.next = null;  // Break the circular connection
            return head;          // No rotation needed
        }

        // Step 3: Find the new tail
        int newTailPosition = length - k - 1;
        ListNode newTail = head;
        for (int i = 0; i < newTailPosition; i++) {
            newTail = newTail.next;
        }

        // Step 4: Determine the new head
        ListNode newHead = newTail.next;

        // Break the circular connection
        newTail.next = null;

        return newHead;
    }

    // Helper function to create a linked list from an array
    public static ListNode createLinkedList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper function to print linked list
    public static void printLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the linked list
        System.out.println("Enter the number of nodes in the linked list:");
        int n = scanner.nextInt();
        int[] values = new int[n];

        System.out.println("Enter the values for the linked list (space-separated):");
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        // Create the linked list
        ListNode head = createLinkedList(values);
        System.out.println("Original List:");
        printLinkedList(head);

        // Input for the number of places to rotate
        System.out.println("Enter the number of places to rotate:");
        int k = scanner.nextInt();

        // Rotate the linked list
        head = rotateRight(head, k);
        System.out.println("Rotated List by " + k + " places:");
        printLinkedList(head);

        scanner.close();
    }
}
