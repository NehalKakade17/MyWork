//============================================================================
// Name        : Assignment-3(Q1).cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <cstring>

class String {
private:
    int length;      // To store the length of the string
    char *str;       // Pointer to dynamically allocated memory for the string

public:
    // Constructor to initialize the empty string
    String() {
        length = 0;
        str = new char[1]; // Allocate memory for an empty string
        str[0] = '\0'; // Null-terminate the string
    }

    // Destructor to release dynamically allocated memory
    ~String() {
        delete[] str; // Free the dynamically allocated memory
    }

    // Member function to accept a string
    void acceptRecord(const char* inputStr) {
        length = std::strlen(inputStr); // Get the length of the input string
        str = new char[length + 1];     // Allocate memory for the new string (+1 for the null terminator)
        std::strcpy(str, inputStr);     // Copy the input string to the dynamically allocated memory
    }

    // Member function to print the stored string
    void printRecord() const {
        std::cout << "Stored String: " << str << std::endl;
    }

    // Getter function for the length (optional but useful for some cases)
    int getLength() const {
        return length;
    }
};

int main() {
    // Create an object of String
    String s;

    // Accept a string
    s.acceptRecord("Hello, World!");

    // Print the string
    s.printRecord();

    return 0;
}

