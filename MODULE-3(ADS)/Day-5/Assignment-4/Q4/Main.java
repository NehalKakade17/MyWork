import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SortedLinkedList {
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

    // Method to merge two sorted linked lists
    public static SortedLinkedList merge(SortedLinkedList list1, SortedLinkedList list2) {
        Node dummy = new Node(0); // Dummy node to simplify merging
        Node tail = dummy;

        Node p1 = list1.head;
        Node p2 = list2.head;

        while (p1 != null && p2 != null) {
            if (p1.data <= p2.data) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }

        // Attach the remaining nodes
        if (p1 != null) {
            tail.next = p1;
        } else {
            tail.next = p2;
        }

        SortedLinkedList mergedList = new SortedLinkedList();
        mergedList.head = dummy.next; // Skip the dummy node
        return mergedList;
    }
}

public class Main {
    public static void main(String[] args) {
        SortedLinkedList list1 = new SortedLinkedList();
        SortedLinkedList list2 = new SortedLinkedList();
        Scanner scanner = new Scanner(System.in);

        // Input for the first sorted linked list
        System.out.println("Enter integers for the first sorted linked list (type 'done' to finish):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int value = Integer.parseInt(input);
                list1.insert(value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer or 'done' to finish.");
            }
        }

        // Input for the second sorted linked list
        System.out.println("Enter integers for the second sorted linked list (type 'done' to finish):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int value = Integer.parseInt(input);
                list2.insert(value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer or 'done' to finish.");
            }
        }

        // Print the original lists
        System.out.println("List 1:");
        list1.printList();
        System.out.println("List 2:");
        list2.printList();

        // Merging the two sorted lists
        SortedLinkedList mergedList = SortedLinkedList.merge(list1, list2);

        // Print the merged list
        System.out.println("Merged List:");
        mergedList.printList();

        scanner.close();
    }
}
