package homework;
import java.util.*;
class Employee{
	private int emp_id;
	private String name;
	private String address;
	Scanner sc =new Scanner(System.in);
	Employee(){
		this.emp_id = 0;
		this.name = null;
		this.address = null;
	}
	public void setRecord() {
		System.out.print("Employee Id: ");
		this.emp_id = sc.nextInt();
		sc.nextLine();
		System.out.print("Employee name: ");
		this.name =  sc.nextLine();
		System.out.print("Employee Address: ");
		this.address = sc.nextLine();
	}
	public void printRecord() {
		System.out.println("Employee Id: "+this.emp_id);
		System.out.println("Employee name: "+this.name);
		System.out.println("Employee Address: "+this.address);
	}
}
public class Test {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.printRecord();
		emp.setRecord();
		emp.printRecord();

	}

}
