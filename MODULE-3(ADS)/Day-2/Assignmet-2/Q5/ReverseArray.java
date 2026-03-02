import java.util.Scanner;

public class ReverseArray {
    public static void reverseArray(int[] arr, int start, int end) {
            if (start >= end) {
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        reverseArray(arr, 0, n - 1);
        System.out.println("Reversed array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        sc.close();
    }
}
