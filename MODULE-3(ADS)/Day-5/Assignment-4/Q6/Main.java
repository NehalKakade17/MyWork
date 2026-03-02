import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
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

    // Method to remove duplicates from the sorted linked list
    public void removeDuplicates() {
        Node current = head;

        while (current != null && current.next != null) {
            // If current node's data is the same as the next node's data
            if (current.data == current.next.data) {
                // Skip the next node
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }
    }

    // Method to print the list
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
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        // Input for the sorted linked list
        System.out.println("Enter integers for the sorted linked list (type 'done' to finish):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int value = Integer.parseInt(input);
                list.insert(value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer or 'done' to finish.");
            }
        }

        // Print the original list
        System.out.println("Original List:");
        list.printList();

        // Remove duplicates
        list.removeDuplicates();

        // Print the list after removing duplicates
        System.out.println("List after removing duplicates:");
        list.printList();

        scanner.close();
    }
}
