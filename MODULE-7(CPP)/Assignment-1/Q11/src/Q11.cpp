//============================================================================
// Name        : Q7.cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

class Person {
    // Private members can only be accessed by member functions or friends of the class
private:
    string name;
    int age;

    // Private member function
    void setAge(int a) {
        age = a;
    }

public:
    // Public members can be accessed by any function or object
    Person(string n, int a) {
        name = n;        // Initialize public member directly
        setAge(a);       // Private function is called within public constructor
    }

    void displayDetails() {
        cout << "Name: " << name << endl;
        cout << "Age: " << age << endl;
    }

    // Public function to set the name
    void setName(string n) {
        name = n;
    }

protected:
    // Protected members can be accessed by derived classes or member functions
    string address;

public:
    // Public member function to set address (from outside the class)
    void setAddress(string addr) {
        address = addr;
    }

    // A public function to get the address (from outside the class)
    string getAddress() {
        return address;
    }
};

// Derived class inheriting from Person
class Employee : public Person {
private:
    int employeeId;

public:
    Employee(string n, int a, int id) : Person(n, a) {
        employeeId = id;
    }

    void displayEmployeeDetails() {
        displayDetails();  // Call the base class function
        cout << "Employee ID: " << employeeId << endl;
        cout << "Address: " << address << endl;  // Access protected member from base class
    }
};

int main() {
    // Creating an object of Person class
    Person person1("Alice", 30);

    // Accessing public member functions
    person1.displayDetails();
    person1.setName("Bob");
    person1.setAddress("123 Main St");

    // Accessing updated details after changing the name and address
    cout << "\nUpdated Details:" << endl;
    person1.displayDetails();
    cout << "Address: " << person1.getAddress() << endl;

    // Creating an object of Employee class (derived from Person)
    Employee emp1("Charlie", 25, 101);
    cout << "\nEmployee Details:" << endl;
    emp1.displayEmployeeDetails();

    return 0;
}




