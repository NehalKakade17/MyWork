import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
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
        newNode.prev = last;
    }

    // Method to reverse the doubly linked list
    public void reverse() {
        Node current = head;
        Node temp = null;

        // Swap next and prev for each node
        while (current != null) {
            temp = current.prev; // Store the prev node
            current.prev = current.next; // Swap prev and next
            current.next = temp; // Assign the stored prev to next
            current = current.prev; // Move to the next node in original order
        }

        // Adjust head to point to the new front of the list
        if (temp != null) {
            head = temp.prev;
        }
    }

    // Method to traverse and print the list
    public void traverse() {
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
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);

        // Input for inserting nodes
        System.out.println("Enter integers to insert into the doubly linked list (type 'done' to finish):");
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

        // Traverse and print the list before reversal
        System.out.println("Original List:");
        list.traverse();

        // Reverse the list
        list.reverse();

        // Traverse and print the list after reversal
        System.out.println("Reversed List:");
        list.traverse();

        scanner.close();
    }
}
