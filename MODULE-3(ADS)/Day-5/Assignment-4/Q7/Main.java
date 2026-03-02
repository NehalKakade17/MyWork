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

    // Method to delete a node by key
    public void delete(int key) {
        Node current = head;

        // If the list is empty
        if (current == null) {
            System.out.println("List is empty.");
            return;
        }

        // Traverse the list to find the node to delete
        while (current != null) {
            if (current.data == key) {
                // Node is found; adjust pointers
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    // This was the head node
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                System.out.println("Deleted node with value: " + key);
                return;
            }
            current = current.next;
        }
        System.out.println("Node with value " + key + " not found.");
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

        // Traverse and print the list
        list.traverse();

        // Input for deleting a node
        System.out.print("Enter the value of the node to delete: ");
        int key = scanner.nextInt();
        list.delete(key);

        // Traverse and print the list after deletion
        list.traverse();

        scanner.close();
    }
}
