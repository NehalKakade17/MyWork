import java.util.Scanner;

class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor to initialize the Max-Heap
    public MaxHeap(int capacity) {
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

    // Method to maintain the max-heap property after insertion
    private void heapifyUp(int index) {
        while (index != 0 && heap[parent(index)] < heap[index]) {
            // Swap
            int temp = heap[index];
            heap[index] = heap[parent(index)];
            heap[parent(index)] = temp;
            index = parent(index);
        }
    }

    // Method to extract the maximum element (root) without removing it
    public int extractMax() {
        if (size == 0) {
            System.out.println("Heap is empty. Cannot extract max.");
            return Integer.MIN_VALUE;
        }
        return heap[0]; // Return the maximum element without removing it
    }

    // Method to maintain the max-heap property after removal
    private void heapifyDown(int index) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != index) {
            // Swap
            int temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;
            heapifyDown(largest);
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
        MaxHeap maxHeap = new MaxHeap(capacity);

        while (true) {
            System.out.println("1. Insert\n2. Extract Max\n3. Display Heap\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int element = scanner.nextInt();
                    maxHeap.insert(element);
                    break;
                case 2:
                    int maxElement = maxHeap.extractMax();
                    if (maxElement != Integer.MIN_VALUE) {
                        System.out.println("Max element: " + maxElement);
                    }
                    break;
                case 3:
                    System.out.println("Heap elements: ");
                    maxHeap.display();
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
