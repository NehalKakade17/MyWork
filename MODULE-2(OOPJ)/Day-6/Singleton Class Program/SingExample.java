package homework;
import java.util.*;
class Singleton{
	static Scanner sc = new Scanner(System.in);
	static private int num;
	private static Singleton ref = null;
	Singleton(){
		Singleton.num = 0;
		System.out.println("Initial: "+Singleton.num);
	}
	public int getNum() {
		return num;
	}
	public void setNum() {
		System.out.print("Enter a number: ");
		Singleton.num = sc.nextInt();
	}
	public static Singleton getRef() {
		if(ref == null) {
			ref = new Singleton();
		}
		return ref;
	}
}
public class SingExample {
	
	public static void main(String[] args) {
		Singleton s = Singleton.getRef();
//		Singleton s1 = new Singleton();
		s.setNum();
		System.out.println("Number: "+s.getNum());
		Singleton ss = Singleton.getRef();//not executed
	}

}
