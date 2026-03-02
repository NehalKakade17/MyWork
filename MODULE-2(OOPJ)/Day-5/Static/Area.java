package homework;
import java.util.*;
class Shapes{
	private static double pi = 3.14;
	static int i = 0;
	static Scanner sc = new Scanner(System.in);
	
	public static void calculation(){
		System.out.println("1.Circle");
		System.out.println("2.Ellipse");
		System.out.println("3.Exit");
		System.out.print("Enter your choice: ");
		 i = sc.nextInt();
		 Shapes.choice();
		
	}
	public static void circle() {
		System.out.print("Enter radius: ");
		double r = sc.nextDouble();
		double area = pi*r*r;
		System.out.println("Area: "+area);
		calculation();
	}
	public static void ellipse() {
		System.out.print("Enter major axis: ");
		double a = sc.nextDouble();
		System.out.print("Enter minor axis: ");
		double b = sc.nextDouble();
		double area = pi*a*b;
		System.out.println("Area: "+area);
		calculation();
	}
	public static void choice() {
		if(Shapes.i == 1) {
			Shapes.circle();
		}
		else if(i == 2) {
			Shapes.ellipse();
		}
		else if(i == 3) {
			Shapes.end();
		}
		else {
			System.out.println("Wrong Input");
		}
	}
	public static void end() {
		System.out.println("THE END");
		sc.close();
	}

}
public class Area {

	public static void main(String[] args) {
		Shapes.calculation();

	}

}
