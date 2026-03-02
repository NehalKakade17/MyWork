package hardproblems;
import java.util.function.*;
public class PredicateEg {

	public static void main(String[] args) {
		Predicate<Integer> p = (Integer num) -> num % 2 == 0;
		int num = 20;
		boolean result = p.test(num);
		System.out.println(result);

	}

}
