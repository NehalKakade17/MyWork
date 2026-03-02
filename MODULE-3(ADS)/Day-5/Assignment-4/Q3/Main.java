import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    // Method to insert a new node at the end
    public void insert(int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    // Method to detect a cycle using Floyd's Cycle Detection Algorithm
    public boolean hasCycle() {
        Node slow = head; // Tortoise
        Node fast = head; // Hare

        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow by 1
            fast = fast.next.next;    // Move fast by 2

            if (slow == fast) { // Cycle detected
                return true;
            }
        }
        return false; // No cycle
    }

    // Method to print the list (for debugging)
    public void printList() {
        Node current = head;
        System.out.print("List = [");
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
            if (current != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter integers to insert into the linked list (type 'done' to finish):");

        // Input loop for inserting values
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                int value = Integer.parseInt(input);
                list.insert(value);
                System.out.println("Inserted: " + value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer or 'done' to finish.");
            }
        }

        System.out.println("Original List:");
        list.printList();

        // Check for cycle
        if (list.hasCycle()) {
            System.out.println("Cycle detected in the linked list.");
        } else {
            System.out.println("No cycle detected in the linked list.");
        }

        scanner.close();
    }
}
            
