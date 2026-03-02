package assign3;

public class SumOfDigits {
	void sod(int num) {
		int sum = 0;
		int digit = 0;
		while(num>0) {
			digit = num%10;
			sum = sum+digit;
			num = num/10;
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		SumOfDigits s = new SumOfDigits();
		int n = 9876;
		s.sod(n);

	}

}
