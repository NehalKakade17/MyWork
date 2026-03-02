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

    // Method to find the nth node from the end
    public Integer findNthFromEnd(int n) {
        Node mainPointer = head;
        Node referencePointer = head;

        // Move referencePointer n nodes ahead
        for (int i = 0; i < n; i++) {
            if (referencePointer == null) {
                return null; // n is greater than the length of the list
            }
            referencePointer = referencePointer.next;
        }

        // Move both pointers until referencePointer reaches the end
        while (referencePointer != null) {
            mainPointer = mainPointer.next;
            referencePointer = referencePointer.next;
        }

        return mainPointer.data; // mainPointer is now at the nth node from the end
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

        // Input for the linked list
        System.out.println("Enter integers for the linked list (type 'done' to finish):");
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

        // Input for nth node from the end
        System.out.print("Enter the value of n to find the nth node from the end: ");
        int n = scanner.nextInt();

        // Finding the nth node from the end
        Integer nthNodeValue = list.findNthFromEnd(n);
        if (nthNodeValue != null) {
            System.out.println("The " + n + "th node from the end is: " + nthNodeValue);
        } else {
            System.out.println("The list is shorter than " + n + " nodes.");
        }

        scanner.close();
    }
}
