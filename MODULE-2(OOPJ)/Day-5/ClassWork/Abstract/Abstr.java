package selfstudy;
import java.util.Scanner;
abstract class Calc{
	abstract void area();
	abstract void volume();
	abstract void surface();
	static Scanner sc = new Scanner(System.in);
}
abstract class Square extends Calc{
	private static double side;
	public static void area(double side) {
		Square.side = side;
		double area = side*side;
		System.out.println("Area of Square: "+area);
	}
	public static void volume(double side) {
		Square.side = side;
		double vol = side*side*side;
		System.out.println("Volume of Square: "+vol);
	}
	public static void surface(double side) {
		Square.side = side;
		double surf = 6*side*side;
		System.out.println("Surface Area of Square: "+surf);
	}
	public static double input() {
		System.out.print("Enter side for Square: ");
		 Square.side = sc.nextDouble();
		 return Square.side;
	}
}
public class Abstr {
	static Scanner sc = new Scanner(System.in);
	private static int menuList() {
		System.out.println("Select for Square:-");
		System.out.println("1.Area");
		System.out.println("2.Volume");
		System.out.println("3.Surface Area");
		System.out.println("4.Exit");
		System.out.print("Enter Choice: ");
		int choice = sc.nextInt();
		return choice;
	}
	public static void main(String[] args) {
		 int choice;
		 while((choice = Abstr.menuList())!= 4) {
			 
			 switch(choice) {
			 case 1:
				 Square.area(Square.input());
				 break;
			 case 2:
				 Square.volume(Square.input());
				 break;
			 case 3:
				 Square.surface(Square.input());
				 break;
			default:
				System.out.println("Invalid Choice!!");
			 }
		 }
		 sc.close();

	}

}
