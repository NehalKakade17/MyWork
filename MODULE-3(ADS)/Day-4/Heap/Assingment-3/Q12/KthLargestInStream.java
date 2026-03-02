import java.util.Scanner;

public class KthLargestInStream {
    private int[] minHeap;
    private int size;
    private int capacity;

    // Constructor to initialize the Min-Heap and k value
    public KthLargestInStream(int k) {
        this.capacity = k; // The size of the heap will be k
        this.minHeap = new int[capacity];
        this.size = 0;
    }

    // Method to add a new number to the heap
    public void add(int num) {
        if (size < capacity) {
            minHeap[size] = num;
            size++;
            heapifyUp(size - 1);
        } else if (num > minHeap[0]) {
            minHeap[0] = num;
            heapifyDown(0);
        }
    }

    // Method to maintain the heap property after insertion
    private void heapifyUp(int index) {
        while (index > 0 && minHeap[parent(index)] > minHeap[index]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    // Method to maintain the heap property after removal
    private void heapifyDown(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && minHeap[left] < minHeap[smallest]) {
            smallest = left;
        }
        if (right < size && minHeap[right] < minHeap[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // Method to swap two elements in the heap
    private void swap(int i, int j) {
        int temp = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = temp;
    }

    // Methods to get parent and child indices
    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Method to get the k-th largest element
    public int getKthLargest() {
        return minHeap[0]; // The root of the Min-Heap is the k-th largest element
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read value of k
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        // Read the number of elements in the stream
        System.out.print("Enter the number of elements in the stream: ");
        int n = scanner.nextInt();

        KthLargestInStream kthLargest = new KthLargestInStream(k);

        // Read elements of the stream
        System.out.println("Enter the elements of the stream:");
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            kthLargest.add(num);
        }

        // Output the k-th largest element
        System.out.println("The " + k + "-th largest element is: " + kthLargest.getKthLargest());
        
        scanner.close();
    }
}
