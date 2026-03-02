import java.util.Scanner;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class SortedCircularLinkedList {

    // Method to insert a node in a sorted circular linked list
    public static Node insertSorted(Node head, int value) {
        Node newNode = new Node(value);

        // If the list is empty, create a new circular list with the new node
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node current = head;

        // If the new value is smaller than the head or if we need to insert at the end
        if (value < head.val) {
            // Find the last node
            while (current.next != head) {
                current = current.next;
            }
            // Insert before the head
            current.next = newNode;
            newNode.next = head;
            return newNode; // New node becomes the new head
        }

        // Traverse the list to find the insertion point
        while (current.next != head && current.next.val < value) {
            current = current.next;
        }

        // Insert the new node
        newNode.next = current.next;
        current.next = newNode;

        return head; // Return the unchanged head
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

    // Helper function to create a sorted circular linked list from user input
    public static Node createSortedCircularList(Scanner scanner) {
        Node head = null;

        while (true) {
            System.out.print("Enter a number to add to the sorted circular linked list (or -1 to stop): ");
            int value = scanner.nextInt();
            if (value == -1) break;

            head = insertSorted(head, value);
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create a sorted circular linked list from user input
        Node head = createSortedCircularList(scanner);

        System.out.println("Sorted Circular Linked List:");
        printCircularList(head);

        // Insert a new node
        System.out.print("Enter a value to insert into the sorted circular linked list: ");
        int valueToInsert = scanner.nextInt();
        head = insertSorted(head, valueToInsert);

        System.out.println("Updated Sorted Circular Linked List:");
        printCircularList(head);

        scanner.close();
    }
}
