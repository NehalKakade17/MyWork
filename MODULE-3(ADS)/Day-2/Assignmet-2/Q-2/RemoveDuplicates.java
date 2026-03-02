
import java.util.*;

public class RemoveDuplicates {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the sorted array: ");
        int n = sc.nextInt();
        int[] sortedArray = new int[n];
        System.out.println("Enter the elements of the sorted array:");
        for (int i = 0; i < n; i++) {
            sortedArray[i] = sc.nextInt();
        }
	Arrays.sort(sortedArray);
        int newLength = removeDuplicates(sortedArray, 0, 1);
       
        System.out.println("New length: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(sortedArray[i] + " ");
        }
        sc.close();
    }
    public static int removeDuplicates(int[] arr, int index, int next) {
        if (next >= arr.length) {
            return index; 
        }
        if (arr[index] != arr[next]) {
            index++;
            arr[index] = arr[next];
        }
        return removeDuplicates(arr, index, next + 1);
    }
}

