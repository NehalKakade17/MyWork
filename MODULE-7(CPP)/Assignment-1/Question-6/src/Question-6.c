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
    const int var = 10;  // A constant integer
    const int *ptr = &var;  // Pointer to a constant integer

    printf("Before type-casting:\n");
    printf("Value of var: %d\n", var);
    printf("Value through ptr: %d\n", *ptr);

    // Type-casting the const pointer to a non-const pointer
    int *nonConstPtr = (int *)ptr;  // Casting const int* to int*

    // Now we attempt to modify the value through the non-const pointer
    *nonConstPtr = 20;  // This is undefined behavior!

    printf("\nAfter type-casting and modifying the value through non-const pointer:\n");
    printf("Value of var: %d\n", var);
    printf("Value through ptr: %d\n", *ptr);  // This should print 20, but it is unsafe!

    return 0;
}






