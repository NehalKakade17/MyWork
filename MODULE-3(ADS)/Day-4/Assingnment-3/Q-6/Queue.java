import java.util.Scanner;

public class Queue {
    private int[] queue;  // Array to hold the queue elements
    private int front;     // Index of the front element
    private int rear;      // Index of the rear element
    private int capacity;  // Maximum capacity of the queue
    private int size;      // Current size of the queue

    // Constructor to initialize the queue
    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Method to add an element to the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue " + item);
            return;
        }
        rear = (rear + 1) % capacity; // Circular increment
        queue[rear] = item;
        size++;
        System.out.println("Enqueued: " + item);
    }

    // Method to remove an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1; // Indicate that the queue is empty
        }
        int item = queue[front];
        front = (front + 1) % capacity; // Circular increment
        size--;
        System.out.println("Dequeued: " + item);
        return item;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Method to display the contents of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the capacity of the queue: ");
        int capacity = scanner.nextInt();
        Queue queue = new Queue(capacity);
        scanner.nextLine(); // Consume newline character

        while (true) {
            System.out.print("\nEnter command (enqueue <value>, dequeue, display, exit): ");
            String command = scanner.nextLine().trim();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            } else if (command.startsWith("enqueue")) {
                String[] parts = command.split(" ");
                if (parts.length == 2) {
                    try {
                        int item = Integer.parseInt(parts[1]);
                        queue.enqueue(item);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                } else {
                    System.out.println("Invalid command. Use 'enqueue <value>'.");
                }
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
