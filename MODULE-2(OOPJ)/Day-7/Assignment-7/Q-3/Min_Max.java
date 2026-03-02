package homework;
import java.util.*;
public class Min_Max {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int[] arr =new int[5];
		System.out.println("For Array:-");
		for(int i =0;i<arr.length;i++) {
			System.out.print("Enter value for "+i+": ");
			arr[i] = sc.nextInt();
		}
		int max = 0;
		int min = arr[0];
		for(int num : arr) {
			max = Math.max(num, max);
			min = Math.min(num, min);
			
		}
		System.out.println("Maximum is: "+max);
		System.out.println("Minimum is: "+min);

	}

}
