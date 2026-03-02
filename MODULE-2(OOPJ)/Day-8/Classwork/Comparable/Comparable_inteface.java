package selfstudy;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


class Employee implements Comparable<Employee> {
	int emp_id;
	String emp_name;
	double emp_salary;
	Employee(int id,String name,double salary){
		this.emp_id = id;
		this.emp_name = name;
		this.emp_salary = salary;
	}
	public int getId() {
		return this.emp_id;
	}
	public String getName() {
		return this.emp_name;
	}
	public double getSalary() {
		return this.emp_salary;
	}
	@Override
	public int compareTo(Employee other) {
		 return Integer.compare(this.emp_id, other.emp_id);
	}
	@Override
	public String toString() {
		return "[emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_salary=" + emp_salary + "]";
	}
	
	
}
public class Comparable_inteface {

	public static void main(String[] args) {
		List<Employee> emp = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		emp.add(new Employee(1,"nehal",30000));
		emp.add(new Employee(2,"shreya",50000));
		emp.add(new Employee(5,"swara",80000));
		emp.add(new Employee(3,"lisa",36000));
		emp.add(new Employee(4,"meera",77000));
		System.out.print("Enter sorting method from id,name,salary: ");
		String choice = sc.next().toLowerCase();
		switch(choice) {
		case "id":
			Collections.sort(emp);
			break;
			
		case "name":
			Collections.sort(emp,Comparator.comparing(Employee::getName));
			break;
		case "salary":
			Collections.sort(emp,Comparator.comparingDouble(Employee::getSalary));
			break;
		default:
			System.out.println("Invalid Choice!!");
		}
		for (Employee e : emp) {
            System.out.println(e);
        }
		sc.close();
	}
	

}
