package homework;
import java.util.*;
public class Narrowing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a decimal value:");
		double d = sc.nextDouble();
		int val = (int) d;
		System.out.print("Integer value: "+val);
		sc.close();

	}

}
