import java.util.Scanner;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class SplitCircularLinkedList {

    public static Node[] splitCircularList(Node head) {
        // Check for empty list
        if (head == null) {
            return new Node[] {null, null};
        }

        Node slow = head;
        Node fast = head;

        // Use two pointers to find the midpoint
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Slow is now at the midpoint
        Node head1 = head; // First half starts from head
        Node head2 = slow.next; // Second half starts from slow.next

        // Break the circular links
        slow.next = head1; // End the first half
        fast.next = head2; // End the second half

        return new Node[] {head1, head2}; // Return both halves
    }

    // Helper function to print the circular linked list
    public static void printCircularList(Node head) {
        if (head == null) return;

        Node current = head;
        do {
            System.out.print(current.val + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    // Helper function to create a circular linked list from user input
    public static Node createCircularList(Scanner scanner) {
        System.out.print("Enter the number of nodes: ");
        int n = scanner.nextInt();

        if (n == 0) return null;

        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value for node " + (i + 1) + ": ");
            int value = scanner.nextInt();
            Node newNode = new Node(value);

            if (head == null) {
                head = newNode; // Set head for the first node
            } else {
                tail.next = newNode; // Link new node to the list
            }
            tail = newNode; // Update tail
        }

        // Make the list circular
        if (tail != null) {
            tail.next = head; // Last node points to head
        }

        return head; // Return the head of the circular list
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create a circular linked list from user input
        Node head = createCircularList(scanner);

        System.out.println("Original Circular Linked List:");
        printCircularList(head);

        // Split the circular linked list
        Node[] splitLists = splitCircularList(head);
        Node head1 = splitLists[0];
        Node head2 = splitLists[1];

        System.out.println("First Half:");
        printCircularList(head1);
        System.out.println("Second Half:");
        printCircularList(head2);

        scanner.close();
    }
}
