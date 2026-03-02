import java.util.Scanner;

class Node {
    int data; // Data type is integer
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    // Insert a new node at the end
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

    // Delete a node with a specific value
    public boolean delete(int key) {
        Node current = head;
        Node previous = null;

        // If the head node itself holds the key
        if (current != null && current.data == key) {
            head = current.next; // Change head
            return true;
        }

        // Search for the key to be deleted
        while (current != null && current.data != key) {
            previous = current;
            current = current.next;
        }

        // If key was not present in the list
        if (current == null) {
            return false;
        }

        // Unlink the node
        previous.next = current.next;
        return true;
    }

    // Search for a node with a specific value
    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Print the list
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

        // Prompt for commands
        System.out.println("Enter commands (e.g., 'Insert 5', 'Delete 3', 'Search 10'). Type 'exit' to quit.");

        while (true) {
            String command = scanner.nextLine();

            // Exit condition
            if (command.equalsIgnoreCase("exit")) {
                break;
            }

            // Split the command into parts
            String[] parts = command.split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid command. Please provide an action and a number.");
                continue;
            }

            String action = parts[0].toLowerCase();
            int value;

            try {
                value = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter an integer.");
                continue;
            }

            switch (action) {
                case "insert":
                    list.insert(value);
                    System.out.println("Inserted: " + value);
                    break;

                case "delete":
                    boolean deleted = list.delete(value);
                    if (deleted) {
                        System.out.println("Deleted: " + value);
                    } else {
                        System.out.println("Value not found: " + value);
                    }
                    break;

                case "search":
                    boolean found = list.search(value);
                    System.out.println("Found " + value + ": " + found);
                    break;

                case "print":
                    list.printList();
                    break;

                default:
                    System.out.println("Invalid action. Please use 'Insert', 'Delete', 'Search', or 'Print'.");
            }
        }

        System.out.println("Exiting...");
        scanner.close();
    }
}
