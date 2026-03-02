package homework;
import java.util.Scanner;
class Employee2 {
    private int e_id;
    private String name;
    private int age;
    private Scanner sc = new Scanner(System.in);

    Employee2(int e_id, String name, int age) {
        this.e_id = e_id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "[e_id=" + e_id + ", name=" + name + ", age=" + age + "]";
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void inputEmployeeDetails() {
        System.out.print("Enter employee id: ");
        this.e_id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter employee name: ");
        this.name = sc.nextLine();

        System.out.print("Enter employee age: ");
        this.age = sc.nextInt();
    }
}

public class Program {
    public static void main(String[] args) {
        Employee2 e = new Employee2(0, null, 0);
        System.out.println(e);
        e.inputEmployeeDetails();
        System.out.println(e);
    }
}

