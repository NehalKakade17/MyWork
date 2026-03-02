package assign.pending;
class Vehicle{
	protected String make;
	protected int year;
	Vehicle(){
		this.make = "";
		this.year = 0000;
	}
}
class Car extends Vehicle{
	private String model;
	Car(String make,int year,String model){
		this.make = make;
		this.year = year;
		this.model = model;
	}
	public void displayDetails() {
		System.out.println("Vehicle maker: "+this.make);
		System.out.println("Vehicle year: "+this.year);
		System.out.println("Car model: "+this.model);
	}
}
public class Test {

	public static void main(String[] args) {
		Car c = new Car("TATA",2015,"Nexon");
		c.displayDetails();

	}

}
