package homework;
import java.util.*;
public class Rem_Dup {

	public static void main(String[] args) {
		int[] arr = new int[5];
		Scanner sc =new Scanner(System.in);
		System.out.println("Array is:-");
		for(int i =0;i<arr.length;i++) {
			System.out.print("Enter value for "+i+": ");
			arr[i] =sc.nextInt();
		}
		Arrays.sort(arr);
		int n = arr.length;
		n = removeDuplicates(arr, n);
		System.out.print("[ ");
        for (int i=0; i<n; i++) {
           System.out.print(arr[i]+" ");
        }
        System.out.print(" ]");
        sc.close();
	}
		public static int removeDuplicates(int arr[], int n) {
	    
	        if (n == 0 || n == 1) {
	            return n;
	        }
	        int j = 0;
	        for (int i = 0; i < n-1; i++) {
	            if (arr[i] != arr[i+1]) {
	                arr[j++] = arr[i];
	            }
	        }
	        arr[j++] = arr[n-1];
	     
	        return j;
		}
}


