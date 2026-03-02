//============================================================================
// Name        : Assignment-2(Q4).cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Employee {
private:
    int empID;
    string empName;
    double empSalary;
    double grossSalary;

public:
    // Constructor to initialize the employee details
    Employee(int id, string name, double salary) {
        empID = id;
        empName = name;
        empSalary = salary;
        calculateGrossSalary();
    }

    // Getter and Setter for Employee ID
    int getEmpID() { return empID; }
    void setEmpID(int id) { empID = id; }

    // Getter and Setter for Employee Name
    string getEmpName() { return empName; }
    void setEmpName(string name) { empName = name; }

    // Getter and Setter for Employee Salary
    double getEmpSalary() { return empSalary; }
    void setEmpSalary(double salary) {
        empSalary = salary;
        calculateGrossSalary(); // Recalculate gross salary when salary is updated
    }

    // Method to calculate the gross salary based on the rules
    void calculateGrossSalary() {
        if (empSalary <= 5000) {
            grossSalary = empSalary + (empSalary * 0.10); // 10% bonus
        } else if (empSalary > 5000 && empSalary <= 10000) {
            grossSalary = empSalary + (empSalary * 0.15); // 15% bonus
        } else {
            grossSalary = empSalary + (empSalary * 0.20); // 20% bonus
        }
    }

    // Method to display the employee details
    void displayEmployeeDetails() {
        cout << "Employee ID: " << empID << endl;
        cout << "Employee Name: " << empName << endl;
        cout << "Employee Salary: " << empSalary << endl;
        cout << "Employee Gross Salary: " << grossSalary << endl;
    }

    // Getter for gross salary
    double getGrossSalary() { return grossSalary; }
};

class EmployeePayrollSystem {
private:
    vector<Employee> employees; // List to store all employees

public:
    // Method to add a new employee
    void addEmployee(int id, string name, double salary) {
        // Check if the employee ID already exists
        for (auto& emp : employees) {
            if (emp.getEmpID() == id) {
                cout << "Error: Employee ID already exists!" << endl;
                return;
            }
        }
        Employee newEmp(id, name, salary);
        employees.push_back(newEmp);
        cout << "Employee added successfully!" << endl;
    }

    // Method to calculate and display the gross salary of an employee by ID
    void calculateGrossSalaryByID(int id) {
        for (auto& emp : employees) {
            if (emp.getEmpID() == id) {
                cout << "Gross Salary for Employee ID " << id << ": " << emp.getGrossSalary() << endl;
                return;
            }
        }
        cout << "Employee with ID " << id << " not found!" << endl;
    }

    // Method to display details of an employee by ID
    void displayEmployeeDetailsByID(int id) {
        for (auto& emp : employees) {
            if (emp.getEmpID() == id) {
                emp.displayEmployeeDetails();
                return;
            }
        }
        cout << "Employee with ID " << id << " not found!" << endl;
    }

    // Method to update employee information
    void updateEmployeeInfo(int id, string name, double salary) {
        for (auto& emp : employees) {
            if (emp.getEmpID() == id) {
                emp.setEmpName(name);
                emp.setEmpSalary(salary);
                cout << "Employee information updated successfully!" << endl;
                return;
            }
        }
        cout << "Employee with ID " << id << " not found!" << endl;
    }
};

int main() {
    EmployeePayrollSystem system;
    int choice, empID;
    string empName;
    double empSalary;

    while (true) {
        cout << "\nEmployee Payroll Management System Menu:" << endl;
        cout << "1. Add a new employee" << endl;
        cout << "2. Calculate gross salary for an employee" << endl;
        cout << "3. Display employee details" << endl;
        cout << "4. Update employee information" << endl;
        cout << "5. Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1:
                // Add a new employee
                cout << "Enter Employee ID: ";
                cin >> empID;
                cin.ignore();  // To ignore the newline character left by cin
                cout << "Enter Employee Name: ";
                getline(cin, empName);
                cout << "Enter Employee Salary: ";
                cin >> empSalary;
                system.addEmployee(empID, empName, empSalary);
                break;

            case 2:
                // Calculate gross salary for an employee by ID
                cout << "Enter Employee ID: ";
                cin >> empID;
                system.calculateGrossSalaryByID(empID);
                break;

            case 3:
                // Display employee details by ID
                cout << "Enter Employee ID: ";
                cin >> empID;
                system.displayEmployeeDetailsByID(empID);
                break;

            case 4:
                // Update employee information
                cout << "Enter Employee ID: ";
                cin >> empID;
                cin.ignore();
                cout << "Enter new Employee Name: ";
                getline(cin, empName);
                cout << "Enter new Employee Salary: ";
                cin >> empSalary;
                system.updateEmployeeInfo(empID, empName, empSalary);
                break;

            case 5:
                // Exit the program
                cout << "Exiting the system." << endl;
                return 0;

            default:
                cout << "Invalid choice. Please try again!" << endl;
        }
    }

    return 0;
}

