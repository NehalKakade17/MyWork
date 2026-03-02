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
    int *ptr = NULL;  // Initialize the pointer to NULL

    // Checking if the pointer is NULL before dereferencing
    if (ptr == NULL) {
        printf("The pointer is NULL, dereferencing it would cause an error!\n");
    } else {
        // This block won't be executed since ptr is NULL
        printf("The value pointed to by ptr is: %d\n", *ptr);
    }

    // Properly initialize the pointer to point to a valid memory address
    int var = 20;
    ptr = &var;  // Now ptr points to var

    // Check again if the pointer is NULL before dereferencing
    if (ptr != NULL) {
        printf("The pointer is not NULL, dereferencing is safe.\n");
        printf("The value pointed to by ptr is: %d\n", *ptr);  // Dereferencing safely
    } else {
        printf("The pointer is NULL, can't dereference.\n");
    }

    return 0;
}



