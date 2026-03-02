/*
 ============================================================================
 Name        : Question-1.c
 Author      : nehal
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>

int main() {
    // Declare two integer variables
    int var1 = 10;
    int var2 = 20;

    // Declare a pointer to an integer
    int *ptr;

    // Initialize the pointer with the address of var1
    ptr = &var1;

    // Print the value using both the pointer and the variable
    printf("Using pointer: *ptr = %d\n", *ptr);
    printf("Using variable: var1 = %d\n", var1);

    // Demonstrating pointer assignment
    // Assign the address of var2 to the pointer
    ptr = &var2;

    // Print the value of var2 using the pointer
    printf("After pointer assignment:\n");
    printf("Using pointer: *ptr = %d\n", *ptr);
    printf("Using variable: var2 = %d\n", var2);

    return 0;
}

