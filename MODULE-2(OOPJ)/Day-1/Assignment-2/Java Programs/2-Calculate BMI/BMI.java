package assign2;
import java.util.*;
public class BMI {
	public static void bmiCal(double h, double w) {
		double bm;
		bm = w/(h*h);
		if(bm < 18.5) {
			System.out.println("You are underweight");
		}
		else if(bm>=18.5 && bm<24.9) {
			System.out.println("You are normal");
		}
		else if(bm>=24.9 && bm<29.9) {
			System.out.println("You are overweight");
		}
		else if(bm>=29.9) {
			System.out.println("Obesity");
		}
		
	}

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter your height in m:");
		double h = sc.nextDouble();
		System.out.println("Enter your weight in kg:");
		double w = sc.nextDouble();
		bmiCal(h,w);
		
	}

}
