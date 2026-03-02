package homework;
import java.util.*;
public class Array_met {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int[] arr = new int[5];
		Array_met a = new Array_met();
		a.acceptRecord(arr);
		a.printRecord(arr);

	}
	public void acceptRecord(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print("Enter value for "+i+":");
			arr[i] = sc.nextInt();
		}
	}
	public void printRecord(int[] arr) {
		System.out.print(Arrays.toString(arr));
		Array_met.sc.close();
	}
	

}
