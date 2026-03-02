//============================================================================
// Name        : Assignment-3(Q2).cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>

class Matrix {
private:
    int row;   // Number of rows in the matrix
    int col;   // Number of columns in the matrix
    int **arr; // Pointer to dynamically allocated 2D array to store matrix elements

public:
    // Constructor to initialize the matrix with given number of rows and columns
    Matrix(int r, int c) {
        row = r;
        col = c;

        // Dynamically allocate memory for the matrix
        arr = new int*[row];
        for (int i = 0; i < row; i++) {
            arr[i] = new int[col];
        }
    }

    // Destructor to deallocate the memory used by the matrix
    ~Matrix() {
        for (int i = 0; i < row; i++) {
            delete[] arr[i]; // Deallocate each row
        }
        delete[] arr; // Deallocate the row pointers
    }

    // Member function to accept input from the user for the matrix elements
    void acceptRecord() {
        std::cout << "Enter the elements of the " << row << "x" << col << " matrix:" << std::endl;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                std::cout << "Element [" << i << "][" << j << "]: ";
                std::cin >> arr[i][j];
            }
        }
    }

    // Member function to print the matrix in a human-readable format
    void printRecord() const {
        std::cout << "Matrix: " << std::endl;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                std::cout << arr[i][j] << " ";
            }
            std::cout << std::endl;
        }
    }
};

int main() {
    int rows, cols;

    // Take the number of rows and columns for the matrix
    std::cout << "Enter number of rows: ";
    std::cin >> rows;
    std::cout << "Enter number of columns: ";
    std::cin >> cols;

    // Create the matrix object
    Matrix m(rows, cols);

    // Accept the matrix elements
    m.acceptRecord();

    // Print the matrix
    m.printRecord();

    return 0;
}

