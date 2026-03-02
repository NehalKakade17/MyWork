package selfstudy;

public class Array_shortcut {

	public static void main(String[] args) {
		int [] [] arr = new int[][] {{10,20,30,40},{50,60,70,90},{11,22,33,44}};
		for(int[] row : arr) {
			for(int col : row) {
				System.out.print(col+" ");
			}
			System.out.println();
		}

	}

}
