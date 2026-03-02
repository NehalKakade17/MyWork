package assign3;

public class PatternFull {

	public static void main(String[] args) {
		for (int i = 5; i>0; i--) {
            
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }

            System.out.println();
        }
		for (int i = 2; i <= 6; i++) {
            
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }

        System.out.println();
        }

	}

}
