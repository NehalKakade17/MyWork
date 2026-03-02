package assign.pending;
import java.util.Scanner;
public class BMITracker {
	static Scanner sc = new Scanner(System.in);
	private double weight;
	private double height;
	private double bmi;
	BMITracker(){
		this.weight = 0.0;
		this.height = 0.0;
	}
	BMITracker(double weight,double height){
		this.weight = weight;
		this.height = height;
	}
	public void acceptRecord() {
		System.out.println("Enter details to calculate BMI-");
		System.out.print("Enter your weight in kg: ");
		this.weight = sc.nextDouble();
		System.out.print("Enter your height in meters: ");
		this.height = sc.nextDouble();
	}
	public double calculateBMI() {
		this.bmi = (weight/(height*height));
		return this.bmi;
	}
	public void classifyBMI() {
		if(this.bmi<18.5) {
			System.out.println("You are underweight");
		}
		else if(this.bmi>=18.5 && this.bmi<24.9) {
			System.out.println("You are normal");
		}
		else if(this.bmi>=24.9 && this.bmi<29.9) {
			System.out.println("You are overweight");
		}
		else if(this.bmi >= 29.9) {
			System.out.println("You are obese");
		}
	}
	public void printRecord() {
		System.out.println("Your weight is : "+this.weight);
		System.out.println("Your height is : "+this.height);
		calculateBMI();
		System.out.printf("Your BMI is : %.2f%n",this.bmi);
		classifyBMI();
	}
	public static void main(String[] args) {
		BMITracker bt = new BMITracker();
		bt.acceptRecord();
		bt.printRecord();
		

	}

}
