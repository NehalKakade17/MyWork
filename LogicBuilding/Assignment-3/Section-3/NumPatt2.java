package assign3;

public class NumPatt2 {

	public static void main(String[] args) {
		int i, j;
		int n = 5;
        int num = 1;
        
        for (i = 1; i <=n ; i++) {
            
            for (j = 1; j <= i; j++) {
                
                System.out.print(num + " ");
                
                num++;
            }

            
            System.out.println();
        }
    }

	}


