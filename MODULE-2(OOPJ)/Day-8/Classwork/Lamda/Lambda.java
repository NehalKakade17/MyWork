package hardproblems;
interface Printable{
//	void print();
	void display(String str);
}
public class Lambda {

	public static void main(String[] args) {
		Printable p = (String s)-> System.out.println(s);
		p.display("The next..");
//		p.print();
		

	}

}
