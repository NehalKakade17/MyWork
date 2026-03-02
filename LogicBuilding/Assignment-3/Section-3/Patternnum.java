package assign3;

public class Patternnum {

	public static void main(String[] args) {
		for(int i=1;i<6;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(i);
				if(j<i) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		for(int n=5;n>=1;n--) {
			for(int m=1;m<=n;m++) {
				System.out.print(n);
				if(m<n) {
					System.out.print("*");
				}
			}
			System.out.println();

		}
	}
}
