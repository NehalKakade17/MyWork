import java.util.Scanner;

class Node {
    int val;
    Node next;
    Node prev;
    Node child;

    Node(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
        this.child = null;
    }
}

public class FlattenDoublyLinkedList {

    public static Node flatten(Node head) {
        if (head == null) return null;

        Node current = head;
        Node tail = head;

        // Traverse the list
        while (current != null) {
            // If current node has a child
            if (current.child != null) {
                // Flatten the child list
                Node childHead = flatten(current.child);

                // Connect the current node to the child head
                current.child = null; // Disconnect the child pointer
                Node nextNode = current.next;

                // Connect current to child
                current.next = childHead;
                childHead.prev = current;

                // Find the tail of the flattened child list
                while (tail.next != null) {
                    tail = tail.next;
                }

                // Connect the tail of the child list to the next node
                tail.next = nextNode;
                if (nextNode != null) {
                    nextNode.prev = tail;
                }
            } else {
                tail = current; // Update the tail if no child
            }
            current = current.next; // Move to the next node
        }

        return head; // Return the flattened list
    }

    // Helper function to print the flattened list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Helper function to create a multilevel doubly linked list
    public static Node createMultilevelList(Scanner scanner) {
        System.out.println("Enter number of nodes in the main level:");
        int n = scanner.nextInt();
        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter value for node " + (i + 1) + ":");
            int value = scanner.nextInt();
            Node newNode = new Node(value);

            if (head == null) {
                head = newNode; // Set head for the first node
            } else {
                tail.next = newNode; // Link new node to the list
                newNode.prev = tail;  // Set prev for new node
            }
            tail = newNode; // Update tail

            // Handle child nodes
            System.out.println("Does this node have a child? (yes/no)");
            String hasChild = scanner.next();
            if (hasChild.equalsIgnoreCase("yes")) {
                System.out.println("Enter number of child nodes:");
                int childCount = scanner.nextInt();
                Node childHead = null;
                Node childTail = null;

                for (int j = 0; j < childCount; j++) {
                    System.out.println("Enter value for child node " + (j + 1) + ":");
                    int childValue = scanner.nextInt();
                    Node childNode = new Node(childValue);

                    if (childHead == null) {
                        childHead = childNode; // Set head for child
                    } else {
                        childTail.next = childNode; // Link child node
                        childNode.prev = childTail;  // Set prev for child node
                    }
                    childTail = childNode; // Update child tail
                }

                newNode.child = childHead; // Link child list to the current node
            }
        }

        return head; // Return the head of the multilevel list
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create a multilevel doubly linked list from user input
        Node head = createMultilevelList(scanner);
        
        // Flatten the list
        Node flattenedHead = flatten(head);
        
        // Print the flattened list
        System.out.println("Flattened list:");
        printList(flattenedHead);

        scanner.close();
    }
}
