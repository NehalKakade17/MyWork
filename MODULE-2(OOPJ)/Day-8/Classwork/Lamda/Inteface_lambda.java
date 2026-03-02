package hardproblems;
interface Display{
	void printing(String s);
}
public class Inteface_lambda {
	public static void displaying(String s) {
		System.out.println(s);
	}
	public static void main(String[] args) {
		Display p = Inteface_lambda::displaying;
		p.printing("Good Luck!!");

	}

}
