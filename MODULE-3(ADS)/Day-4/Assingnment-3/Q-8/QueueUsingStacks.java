import java.util.Scanner;

class Stack {
    private int[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize the stack
    public Stack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    // Push an element onto the stack
    public void push(int item) {
        if (top == capacity - 1) {
            System.out.println("Stack is full! Cannot push " + item);
            return;
        }
        stack[++top] = item;
    }

    // Pop an element from the stack
    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty! Cannot pop.");
            return -1; // Indicate that the stack is empty
        }
        return stack[top--];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Get the size of the stack
    public int size() {
        return top + 1;
    }

    // Peek at the top element without removing it
    public int peek() {
        if (top == -1) {
            return -1; // Stack is empty
        }
        return stack[top];
    }
}

class QueueUsingStacks {
    private Stack stack1;
    private Stack stack2;

    // Constructor to initialize the two stacks
    public QueueUsingStacks(int capacity) {
        stack1 = new Stack(capacity);
        stack2 = new Stack(capacity);
    }

    // Method to add an element to the queue
    public void enqueue(int item) {
        stack1.push(item);
        System.out.println("Enqueued: " + item);
    }

    // Method to remove an element from the queue
    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop()); // Move elements to stack2
            }
        }
        if (stack2.isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1; // Indicate that the queue is empty
        }
        int item = stack2.pop();
        System.out.println("Dequeued: " + item);
        return item;
    }

    // Method to display the contents of the queue
    public void display() {
        System.out.print("Queue: ");
        // Display elements in stack2 (dequeue order)
        for (int i = stack2.size() - 1; i >= 0; i--) {
            System.out.print(stack2.pop() + " "); // Temporarily pop for display
        }
        // Display elements in stack1 (enqueue order)
        for (int i = 0; i < stack1.size(); i++) {
            System.out.print(stack1.peek() + " ");
            stack1.pop(); // Temporarily pop for display
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the capacity of the queue: ");
        int capacity = scanner.nextInt();
        QueueUsingStacks queue = new QueueUsingStacks(capacity);

        while (true) {
            System.out.print("\nEnter command (enqueue <value>, dequeue, display, exit): ");
            String command = scanner.next();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            } else if (command.equalsIgnoreCase("enqueue")) {
                int item = scanner.nextInt();
                queue.enqueue(item);
            } else if (command.equalsIgnoreCase("dequeue")) {
                queue.dequeue();
            } else if (command.equalsIgnoreCase("display")) {
                queue.display();
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }

        scanner.close();
    }
}
