package homework;
import java.util.Scanner;

public class ArrayManager {
    private int[] array;
    private int size;
    public ArrayManager(int size) {
        this.size = size;
        this.array = new int[size];
    }
    public void acceptRecord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter " + size + " values for the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Enter value for index " + i + ": ");
            array[i] = sc.nextInt();
        }
        sc.close();
    }
    public void printRecord() {
        System.out.print("Array elements: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayManager manager = new ArrayManager(5);
        manager.acceptRecord();
        manager.printRecord();
    }
}

