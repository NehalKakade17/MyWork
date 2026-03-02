package hardproblems;

import java.util.function.Consumer;

public class ConsumerEg {

	public static void main(String[] args) {
		Consumer<String> c = (String str)-> System.out.println(str);
		c.accept("Good Morning!!");

	}

}
