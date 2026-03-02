package assign3;

public class NumstarRev {

	public static void main(String[] args) {
		int startNumber = 5; 
        for (int i = 0; i < startNumber; i++) {
            
            for (int j = startNumber; j > startNumber - i - 1; j--) {
                System.out.print(j);

                if (j > startNumber - i) {
                    System.out.print("*");
                }
            }
            System.out.println();

	}

	}
}
