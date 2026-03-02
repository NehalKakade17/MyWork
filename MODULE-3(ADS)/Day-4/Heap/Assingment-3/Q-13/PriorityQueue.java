import java.util.Scanner;

class Node {
    int value;
    int priority;

    public Node(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}

class MinHeap {
    Node[] heap;
    int size;
    int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new Node[capacity];
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public void insert(Node node) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert " + node.value);
            return;
        }
        heap[size] = node;
        size++;
        heapifyUp(size - 1);
    }

    private void heapifyUp(int index) {
        while (index != 0 && heap[parent(index)].priority > heap[index].priority) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void swap(int i, int j) {
        Node temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public Node extractMin() {
        if (size == 0) {
            System.out.println("Heap is empty. Cannot extract.");
            return null;
        }
        Node min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && heap[left].priority < heap[smallest].priority) {
            smallest = left;
        }
        if (right < size && heap[right].priority < heap[smallest].priority) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

class PriorityQueue {
    private MinHeap minHeap;

    public PriorityQueue(int capacity) {
        minHeap = new MinHeap(capacity);
    }

    public void enqueue(int value, int priority) {
        minHeap.insert(new Node(value, priority));
    }

    public Node dequeue() {
        return minHeap.extractMin();
    }

    public boolean isEmpty() {
        return minHeap.isEmpty();
    }

    public void displayHeap() {
        for (int i = 0; i < minHeap.size; i++) {
            System.out.print("[" + minHeap.heap[i].value + ", priority: " + minHeap.heap[i].priority + "] ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the capacity of the priority queue: ");
        int capacity = scanner.nextInt();
        PriorityQueue priorityQueue = new PriorityQueue(capacity);

        // Test Case 1
        System.out.println("\nTest Case 1: ");
        System.out.print("How many elements to enqueue? ");
        int n1 = scanner.nextInt();
        for (int i = 0; i < n1; i++) {
            System.out.print("Enter value and priority for element " + (i + 1) + ": ");
            int value = scanner.nextInt();
            int priority = scanner.nextInt();
            priorityQueue.enqueue(value, priority);
        }
        
        System.out.println("Before Dequeue:");
        priorityQueue.displayHeap();
        
        Node dequeuedElement1 = priorityQueue.dequeue();
        System.out.println("Dequeued element = " + (dequeuedElement1 != null ? dequeuedElement1.value : "None"));
        System.out.print("Priority Queue after Dequeue: ");
        priorityQueue.displayHeap();

        // Test Case 2
        System.out.println("\nTest Case 2: ");
        System.out.print("How many elements to enqueue? ");
        int n2 = scanner.nextInt();
        for (int i = 0; i < n2; i++) {
            System.out.print("Enter value and priority for element " + (i + 1) + ": ");
            int value = scanner.nextInt();
            int priority = scanner.nextInt();
            priorityQueue.enqueue(value, priority);
        }

        System.out.println("Before Dequeue:");
        priorityQueue.displayHeap();
        
        Node dequeuedElement2 = priorityQueue.dequeue();
        System.out.println("Dequeued element = " + (dequeuedElement2 != null ? dequeuedElement2.value : "None"));
        System.out.print("Priority Queue after Dequeue: ");
        priorityQueue.displayHeap();

        scanner.close();
    }
}
