package selfstudy;

import java.util.Scanner;

public class TwoD {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Two Dimensional Array-");
		int [][] arr = new int[4][4];
		for(int row=0;row<arr.length;row++) {
			for(int col = 0;col< arr[ row ].length;col++) {
				System.out.print("Enter value for ["+row+"]["+col+"]:");
				arr[row][col] = sc.nextInt();
			}
			
		}
		sc.close();
		for(int row=0;row<arr.length;row++) {
			for(int col = 0;col< arr[ row ].length;col++) {
				System.out.print(arr[row][col]+" ");
			}
			System.out.println();
			
		}
		
	}

}
