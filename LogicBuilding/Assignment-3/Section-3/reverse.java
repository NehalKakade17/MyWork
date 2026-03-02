package assign3;

public class reverse {

	public static void main(String[] args) {
		int num = 1234;
		int rev = 0;
		while(num!=0) {
			int temp = num % 10;
			rev = rev * 10 + temp;
			num /= 10;
		}
		System.out.println("Reverse is "+rev);
	}
	
}
