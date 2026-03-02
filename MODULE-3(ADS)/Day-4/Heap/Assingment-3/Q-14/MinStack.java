import java.util.Scanner;

class MinStack {
    private int[] stack;
    private int[] minStack;
    private int top;
    private int minTop;
    private int capacity;

    public MinStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        minStack = new int[capacity];
        top = -1;
        minTop = -1;
    }

    // Push element onto the stack
    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack overflow. Cannot push " + value);
            return;
        }
        stack[++top] = value;
        // Update the min stack
        if (minTop == -1 || value <= minStack[minTop]) {
            minStack[++minTop] = value;
        }
    }

    // Pop element from the stack
    public int pop() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty");
        }
        int value = stack[top--];
        // Remove from minStack if the popped value is the current minimum
        if (value == minStack[minTop]) {
            minTop--;
        }
        return value;
    }

    // Get the minimum element in constant time
    public int getMin() {
        if (minTop == -1) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack[minTop];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity of the stack: ");
        int capacity = scanner.nextInt();
        MinStack minStack = new MinStack(capacity);

        while (true) {
            System.out.println("\n1. Push\n2. Pop\n3. Get Min\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = scanner.nextInt();
                    minStack.push(value);
                    break;
                case 2:
                    try {
                        int poppedValue = minStack.pop();
                        System.out.println("Popped value: " + poppedValue);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Current Min = " + minStack.getMin());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
