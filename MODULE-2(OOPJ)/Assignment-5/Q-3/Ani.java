package assign.pending;
class Animal{
	public void eat() {
		System.out.println("Animal eats");
	}
	public void sleep() {
		System.out.println("Animal sleeps");
	}
}
class Dog extends Animal{
	public void bark() {
		System.out.println("Dog barks");
	}
}
public class Ani {

	public static void main(String[] args) {
		Dog d = new Dog();
		d.eat();
		d.sleep();
		d.bark();

	}

}
