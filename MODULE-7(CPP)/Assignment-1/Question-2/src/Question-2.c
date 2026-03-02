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
    int *ptr;  // Declare a pointer, but do not initialize it.

    // Demonstrating a wild pointer - accessing it before initialization
    printf("Trying to dereference a wild pointer:\n");
    // The pointer is uninitialized, and dereferencing it is undefined behavior.
    // Uncommenting the following line will result in undefined behavior.
    // printf("Value pointed to by wild pointer: %d\n", *ptr);  // Undefined behavior

    // Proper initialization of the pointer
    int var = 10;
    ptr = &var;  // Initialize pointer to point to the variable `var`

    // Now that the pointer is properly initialized, it points to a valid memory location.
    printf("After initializing the pointer:\n");
    printf("Value pointed to by pointer: %d\n", *ptr);  // Correct usage

    return 0;
}



