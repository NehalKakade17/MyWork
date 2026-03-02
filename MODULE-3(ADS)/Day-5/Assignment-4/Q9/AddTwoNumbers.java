import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);  // Placeholder for the result list
        ListNode current = dummyHead;  // Pointer to build the new list
        int carry = 0;  // To store carry during addition
        
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;  // Get value from l1 or 0
            int val2 = (l2 != null) ? l2.val : 0;  // Get value from l2 or 0
            
            // Calculate the sum and the new carry
            int total = val1 + val2 + carry;
            carry = total / 10;  // Update carry for the next position
            current.next = new ListNode(total % 10);  // Create a new node for the result
            
            // Move to the next nodes
            current = current.next;
            if (l1 != null) l1 = l1.next;  // Move to the next node in l1
            if (l2 != null) l2 = l2.next;  // Move to the next node in l2
        }
        
        return dummyHead.next;  // Return the next of dummy head to skip it
    }

    // Helper function to create a linked list from an array of digits
    public static ListNode createLinkedList(int[] digits) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int digit : digits) {
            current.next = new ListNode(digit);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper function to print linked list
    public static void printLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the first number
        System.out.println("Enter the digits of the first number (space-separated):");
        String[] input1 = scanner.nextLine().split(" ");
        int[] digits1 = new int[input1.length];
        for (int i = 0; i < input1.length; i++) {
            digits1[i] = Integer.parseInt(input1[i]);
        }
        ListNode list1 = createLinkedList(digits1);

        // Input for the second number
        System.out.println("Enter the digits of the second number (space-separated):");
        String[] input2 = scanner.nextLine().split(" ");
        int[] digits2 = new int[input2.length];
        for (int i = 0; i < input2.length; i++) {
            digits2[i] = Integer.parseInt(input2[i]);
        }
        ListNode list2 = createLinkedList(digits2);
        
        // Add the two numbers represented by linked lists
        ListNode sumList = addTwoNumbers(list1, list2);
        
        // Print the result
        System.out.print("Sum List: ");
        printLinkedList(sumList);  // Output the resulting linked list
    }
}
