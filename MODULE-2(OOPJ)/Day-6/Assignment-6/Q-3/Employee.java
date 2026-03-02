package assign.pending;
import java.util.*;
public class Employee {
    private static int totalEmployees = 0;
    private static double totalSalaryExpense = 0.0;
    private String name;
    private int id;
    private double salary;
    public Employee() {
        this.name = "";
        this.id = 0;
        this.salary = 0.0;
    }
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        totalEmployees++;
        totalSalaryExpense += salary;
    }
    public static int getTotalEmployees() {
        return totalEmployees;
    }
    public static void applyRaise(double percentage) {
        System.out.println("Applying raise of " + percentage + "% to all employees.");
    }
    public static double calculateTotalSalaryExpense() {
        return totalSalaryExpense;
    }
    public void updateSalary(double newSalary) {
        totalSalaryExpense -= this.salary;
        this.salary = newSalary;
        totalSalaryExpense += this.salary;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + "]";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[100]; 
        int empCount = 0;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Get Total Number of Employees");
            System.out.println("3. Apply Raise to All Employees");
            System.out.println("4. Calculate Total Salary Expense");
            System.out.println("5. Update Salary of Employee");
            System.out.println("6. Display Employee Details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (empCount >= employees.length) {
                        System.out.println("Employee limit reached.");
                        break;
                    }
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    employees[empCount++] = new Employee(name, id, salary);
                    break;

                case 2:
                    System.out.println("Total number of employees: " + Employee.getTotalEmployees());
                    break;

                case 3:
                    System.out.print("Enter percentage raise: ");
                    double percentage = sc.nextDouble();
                    Employee.applyRaise(percentage);
                    break;

                case 4:
                    System.out.println("Total salary expense: " + Employee.calculateTotalSalaryExpense());
                    break;

                case 5:
                    System.out.print("Enter ID of employee to update: ");
                    int updateId = sc.nextInt();
                    boolean found = false;
                    for (Employee emp : employees) {
                        if (emp != null && emp.getId() == updateId) {
                            System.out.print("Enter new salary: ");
                            double newSalary = sc.nextDouble();
                            emp.updateSalary(newSalary);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 6:
                    for (Employee emp : employees) {
                        if (emp != null) {
                            System.out.println(emp);
                        }
                    }
                    break;

                case 7:
                    sc.close();
                    System.out.println("Exiting.");
                    return;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
