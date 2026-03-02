package selfstudy;
import java.util.Scanner;
class Shape{
	public double area(){
		return 0.0;
	}
}
class Rectangle extends Shape{
	private double length;
	private double breadth;
	public double area(double l,double b) {
		this.length = l;
		this.breadth = b;
		return l*b;
	}
	public double area() {
		return area(this.length,this.breadth);
	}
}
class Circle extends Shape{
	private double radius;
	public double area(double r) {
		this.radius = r;
		return Math.PI*r*r; 
		
	}
	public double area() {
		return area(this.radius);
	}
}
public class Area {
	static Scanner sc = new Scanner(System.in);
	static Shape s = new Shape();
	private static void acceptRecord() {
		if(s instanceof Rectangle) {
			Rectangle rec = (Rectangle) s;
			System.out.print("Enter length: ");
			double len = sc.nextDouble();
			System.out.print("Enter breadth: ");
			double bred = sc.nextDouble();
			rec.area(len,bred);
		}
		else {
			Circle c = (Circle) s;
			System.out.print("Enter radius: ");
			double rad = sc.nextDouble();
			c.area(rad);
		}
		
	}
	private static void printRecord() {
		if(s instanceof Rectangle) {
			Rectangle rec = (Rectangle) s;
			double area = rec.area();
			System.out.printf("Area of Rectangle: %.2f%n",area);
		}
		else {
			Circle c = (Circle) s;
			double area = c.area();
			System.out.printf("Area of Circle: %.2f%n",area);
		}
	}
	private static int menuList() {
		System.out.println("Select-");
		System.out.println("1.Retangle");
		System.out.println("2.Circle");
		System.out.println("3.Exit");
		System.out.print("Enter choice: ");
		int choice = sc.nextInt();
		return choice;
	}

	public static void main(String[] args) {
		int choice;
		while((choice = Area.menuList()) != 3){
			switch(choice) {
			case 1:
				s = new Rectangle();
				Area.acceptRecord();
				Area.printRecord();
				break;
			case 2:
				s = new Circle();
				Area.acceptRecord();
				Area.printRecord();
				break;
			default:
				double d = s.area();
				System.out.println("Default value of area: "+d);
			}
		}
		sc.close();
		

	}

}
