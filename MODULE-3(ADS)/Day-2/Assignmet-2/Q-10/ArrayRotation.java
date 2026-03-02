import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
	System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the number of positions to rotate left: ");
        int d = sc.nextInt();
        d = d % n;
        rotateArray(arr, d);
        System.out.println("Rotated array: " + Arrays.toString(arr));
        
        sc.close(); 
    }
    private static void rotateArray(int[] arr, int d) {
        if (d == 0) {
            return;
        }
        int first = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = first;
        rotateArray(arr, d - 1);
    }
}
