package hardproblems;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierEg {

	public static void main(String[] args) {
		Supplier<Integer> s = () -> new Random().nextInt();
		int num = s.get();
		System.out.println(num);

	}

}
