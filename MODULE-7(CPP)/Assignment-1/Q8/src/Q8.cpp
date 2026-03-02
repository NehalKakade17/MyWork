//============================================================================
// Name        : Q7.cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

// Define a struct with member variables and functions
struct Person {
    string name;
    int age;
    float height;

    // Member function to initialize data members
    void initialize(const string& personName, int personAge, float personHeight) {
        name = personName;
        age = personAge;
        height = personHeight;
    }

    // Member function to display data members
    void display() const {
        cout << "Name: " << name << endl;
        cout << "Age: " << age << endl;
        cout << "Height: " << height << endl;
    }
};

int main() {
    // Create a struct variable and initialize it
    Person person1;
    person1.initialize("John Doe", 30, 5.9);

    // Display the values of the struct members
    person1.display();

    return 0;
}


