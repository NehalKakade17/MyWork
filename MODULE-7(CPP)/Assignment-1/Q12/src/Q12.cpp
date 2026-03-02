//============================================================================
// Name        : Q7.cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
using namespace std;

// Define the Employee class
class Employee {
private:
    string name;
    int id;
    double salary;

public:
    // Member function to initialize data members
    void initialize(string empName, int empId, double empSalary) {
        name = empName;
        id = empId;
        salary = empSalary;
    }

    // Member function to display employee details
    void display() const {
        cout << "Employee ID: " << id << endl;
        cout << "Employee Name: " << name << endl;
        cout << "Employee Salary: $" << salary << endl;
        cout << "----------------------------" << endl;
    }
};

int main() {
    // Create multiple Employee objects
    Employee emp1, emp2, emp3;

    // Initialize employee details
    emp1.initialize("Alice", 101, 50000.50);
    emp2.initialize("Bob", 102, 60000.75);
    emp3.initialize("Charlie", 103, 45000.30);

    // Display employee details
    cout << "Employee Details:\n";
    emp1.display();
    emp2.display();
    emp3.display();

    return 0;
}




