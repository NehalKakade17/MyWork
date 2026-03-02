//============================================================================
// Name        : Assignment-2(Q1).cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
using namespace std;

class Student {
private:
    string name;
    int rollNumber;
    float marks;
    char grade;

public:
    // Constructor to initialize the attributes
    Student() {
        name = "";
        rollNumber = 0;
        marks = 0.0;
        grade = 'F';
    }

    // Getter and Setter for name
    string getName() {
        return name;
    }

    void setName(string n) {
        name = n;
    }

    // Getter and Setter for rollNumber
    int getRollNumber() {
        return rollNumber;
    }

    void setRollNumber(int r) {
        rollNumber = r;
    }

    // Getter and Setter for marks
    float getMarks() {
        return marks;
    }

    void setMarks(float m) {
        marks = m;
    }

    // Getter and Setter for grade
    char getGrade() {
        return grade;
    }

    void setGrade(char g) {
        grade = g;
    }

    // Function to calculate grade based on marks
    void calculateGrade() {
        if (marks >= 90 && marks <= 100) {
            grade = 'A';
        }
        else if (marks >= 80 && marks < 90) {
            grade = 'B';
        }
        else if (marks >= 70 && marks < 80) {
            grade = 'C';
        }
        else if (marks >= 60 && marks < 70) {
            grade = 'D';
        }
        else {
            grade = 'F';
        }
    }
};

int main() {
    Student student;
    int choice;

    while (true) {
        cout << "\nMenu:\n";
        cout << "1. Accept Information\n";
        cout << "2. Display Information\n";
        cout << "3. Calculate Grade\n";
        cout << "4. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        if (choice == 1) {
            string name;
            int rollNumber;
            float marks;

            cout << "Enter student's name: ";
            cin.ignore();  // To clear the newline character left by previous input
            getline(cin, name);

            cout << "Enter student's roll number: ";
            cin >> rollNumber;

            cout << "Enter student's marks: ";
            cin >> marks;

            student.setName(name);
            student.setRollNumber(rollNumber);
            student.setMarks(marks);

            cout << "Information accepted successfully!" << endl;
        }
        else if (choice == 2) {
            cout << "\nStudent Information:\n";
            cout << "Name: " << student.getName() << endl;
            cout << "Roll Number: " << student.getRollNumber() << endl;
            cout << "Marks: " << student.getMarks() << endl;
            cout << "Grade: " << student.getGrade() << endl;
        }
        else if (choice == 3) {
            student.calculateGrade();
            cout << "Grade calculated successfully!" << endl;
        }
        else if (choice == 4) {
            cout << "Exiting the program." << endl;
            break;
        }
        else {
            cout << "Invalid choice! Please try again." << endl;
        }
    }

    return 0;
}

