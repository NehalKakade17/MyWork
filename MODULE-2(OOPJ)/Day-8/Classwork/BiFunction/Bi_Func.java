package hardproblems;

import java.util.function.BiFunction;

interface Test{
	String lowerCase(String s); 
	
}
public class Bi_Func {

	public static void main(String[] args) {
		BiFunction<Integer,Integer,Integer> bi = Integer::sum;
		int result = bi.apply(55,88);
		System.out.println(result);
		Test t = String::toLowerCase;
		String st = t.lowerCase("NEhAL");
		System.out.println(st);
		

	}

}
