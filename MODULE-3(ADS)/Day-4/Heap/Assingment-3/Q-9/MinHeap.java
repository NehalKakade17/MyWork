import java.util.Scanner;

class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor to initialize the Min-Heap
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    // Method to get the index of the parent
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Method to get the index of the left child
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // Method to get the index of the right child
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Method to insert a new element
    public void insert(int element) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert " + element);
            return;
        }
        heap[size] = element;
        size++;
        heapifyUp(size - 1);
    }

    // Method to maintain the min-heap property after insertion
    private void heapifyUp(int index) {
        while (index != 0 && heap[parent(index)] > heap[index]) {
            // Swap
            int temp = heap[index];
            heap[index] = heap[parent(index)];
            heap[parent(index)] = temp;
            index = parent(index);
        }
    }

    // Method to display the heap
    public void display() {
        if (size == 0) {
            System.out.println("Heap is empty.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the heap: ");
        int capacity = scanner.nextInt();
        MinHeap minHeap = new MinHeap(capacity);

        while (true) {
            System.out.println("1. Insert\n2. Display Heap\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int element = scanner.nextInt();
                    minHeap.insert(element);
                    break;
                case 2:
                    System.out.println("Heap elements: ");
                    minHeap.display();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
