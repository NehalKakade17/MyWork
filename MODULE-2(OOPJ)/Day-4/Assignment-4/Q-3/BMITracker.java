package assign4;

public class BMITracker {
	private double weight;
	private double height;
	private double bmi;
	public BMITracker(double weight, double height) {
		this.weight = weight;
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void calBMI() {
		bmi = (weight/(height*height));
		System.out.printf("Your BMI is: %.2f%n",bmi);
	}
	public void displayBMI() {
		if(bmi<18.5) {
			System.out.println("You are Underweight");
		}
		else if(bmi>=18.5 && bmi<24.9) {
			System.out.println("You are Normal");
		}
		else if(bmi>=24.9 && bmi<29.9) {
			System.out.println("You are Overweight");
		}
		else {
			System.out.println("You are Obese");
		}
	}
	
	@Override
	public String toString() {
		return "BMITracker [weight=" + weight + ", height=" + height + "]";
	}
	
	
	
}
