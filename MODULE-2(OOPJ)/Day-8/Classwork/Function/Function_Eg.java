package hardproblems;

import java.util.function.Function;

public class Function_Eg {

	public static void main(String[] args) {
		Function<String,Integer> f = (String s) -> s.length();
		Integer len = f.apply("HindiFilmMusics");
		System.out.print(len);

	}

}
