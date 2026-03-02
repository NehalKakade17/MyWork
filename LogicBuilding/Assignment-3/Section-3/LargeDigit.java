package assign3;
import java.util.*;
public class LargeDigit {
	void ld(int num) {
		int largest = 0;
		while(num>0) {
			int digit = num%10;
			largest = Math.max(digit, largest);
			num = num/10;
		}
		System.out.println(largest);
	}
	public static void main(String[] args) {
		LargeDigit l = new LargeDigit();
		int n = 4825;
		l.ld(n);

	}

}
