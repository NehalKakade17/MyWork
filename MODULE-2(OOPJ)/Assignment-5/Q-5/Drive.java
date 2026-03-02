package assign.pending;
class Vehicle1{
	public void startEngine() {
		System.out.println("Vehicle started...");
	}
	public void stopEngine() {
		System.out.println("Vehicle stopped!!!");
	}
}
class Car1 extends Vehicle1{
	public void startEngine() {
		System.out.println("Car started...");
	}
	public void stopEngine() {
		System.out.println("Car stopped!!!");
	}
}
class MotorCycle extends Car1{
	public void startEngine() {
		System.out.println("Motorcycle started...");
	}
	public void stopEngine() {
		System.out.println("Motorcycle stopped!!!");
	}
}
public class Drive {

	public static void main(String[] args) {
		Vehicle1 v1 = new Vehicle1();
		v1.startEngine();
		v1.stopEngine();
		Vehicle1 v2 = new Car1();
		v2.startEngine();
		v2.stopEngine();
		Vehicle1 v3 = new MotorCycle();
		v3.startEngine();
		v3.stopEngine();

	}

}
