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

// Define a structure
struct Person {
    string name;
    int age;
    float height;
};

int main() {
    // Declare and initialize a structure variable
    Person person1 = {"John Doe", 30, 5.9};

    // Print the members of the structure
    cout << "Name: " << person1.name << endl;
    cout << "Age: " << person1.age << endl;
    cout << "Height: " << person1.height << endl;

    return 0;
}

