package assign2;
import java.util.*;
public class Area {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose a Shape:\n1)Circle\n2)Square\n3)Rectangle");
		int n = sc.nextInt();
		switch(n) {
		case 1:
			System.out.println("Enter radius of circle:");
			double r = sc.nextDouble();
			double a_c = 3.14*r*r;
			System.out.println("Area of circle: "+a_c);
			break;
		case 2:
			System.out.println("Enter side of square:");
			int s = sc.nextInt();
			int a_s = s*s;
			System.out.println("Area of square: "+a_s);
			break;
		case 3:
			System.out.println("Enter length of rectangle:");
			int l = sc.nextInt();
			System.out.println("Enter breadth of rectangle:");
			int b = sc.nextInt();
			int a_r = l*b;
			System.out.println("Area of square: "+a_r);
			break;
		default:
			System.out.println("Enter a valid number for area!");
		}
	}

}
