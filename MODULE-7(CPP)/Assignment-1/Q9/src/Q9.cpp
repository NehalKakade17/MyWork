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

// Define a structure to store student information
struct Student {
    string name;
    int age;
    float marks;

    // Function to input student details
    void inputDetails() {
        cout << "Enter name: ";//ADD ONE SPACE THEN WRITE NAME
        cin.ignore();  // Clear any leftover characters (newline) in the input buffer
        getline(cin, name);  // Read the full name, including spaces

        cout << "Enter age: ";
        cin >> age;

        cout << "Enter marks: ";
        cin >> marks;

        // Clear any remaining newline character after reading age and marks
        cin.ignore();  // This ensures that the input buffer is clean for the next input
    }

    // Function to display student details
    void displayDetails() const {
        cout << "Name: " << name << endl;
        cout << "Age: " << age << endl;
        cout << "Marks: " << marks << endl;
        cout << "----------------------" << endl;
    }
};

int main() {
    // Declare an array of 5 students
    Student students[5];

    // Input details for each student
    cout << "Enter details for 5 students: \n";
    for (int i = 0; i < 5; i++) {
        cout << "\nStudent " << i + 1 << ":\n";
        students[i].inputDetails();
    }

    // Print the details of all students
    cout << "\nList of Student Details: \n";
    for (int i = 0; i < 5; i++) {
        cout << "\nStudent " << i + 1 << ":\n";
        students[i].displayDetails();
    }

    return 0;
}



