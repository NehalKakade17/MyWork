package assign3;

public class NumP3 {

	public static void main(String[] args) {
		int rows = 5;
		for (int i = 1; i <= rows; i++) {
            
            for (int j = 1; j <= i; j++) {
                
                System.out.print(2 * j - 1);

                if (j < i) {
                    System.out.print("*");
                }
            }

            System.out.println();
        }

	}

}
