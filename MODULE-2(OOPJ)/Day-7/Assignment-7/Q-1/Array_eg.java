package homework;
import java.util.Arrays;
import java.util.Scanner;

public class Array_eg {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        System.out.println("Default values of the array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Element at index " + i + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.println("Array is: "+Arrays.toString(arr));
        System.out.print("Enter the index of the element you want to update (0-4): ");
        int index = sc.nextInt();
        if (index >= 0 && index < arr.length) {
            System.out.print("Enter the new value for element at index " + index + ": ");
            int newValue = sc.nextInt();
            arr[index] = newValue;
            System.out.print("Updated values of the array:");
            System.out.println(Arrays.toString(arr));
        } else {
            System.out.println("Invalid index. Please enter a number between 0 and 4.");
        }
        sc.close();
    }
}

