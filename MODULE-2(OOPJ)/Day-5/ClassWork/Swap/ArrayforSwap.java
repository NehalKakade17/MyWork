package selfstudy;
import java.util.Scanner;
public class ArrayforSwap {
	
	public void swap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter elements to swap:");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int [] arr = new int[2];
		arr[0] = a;
		arr[1] = b;
		System.out.println("Before swapping: "+arr[0]+" "+arr[1]);
		int temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
		System.out.println("After swapping: "+arr[0]+" "+arr[1]);
		sc.close();
	}
	
		
	

	public static void main(String[] args) {
		ArrayforSwap a = new ArrayforSwap();
		a.swap();

	}

}
