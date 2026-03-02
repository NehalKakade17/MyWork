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
    int var1 = 10;
    int var2 = 20;
    int var3 = 30;

    // 1. const int *ptr: Pointer to a constant integer
    const int *ptr1 = &var1;
    printf("const int *ptr1 (before modification): %d\n", *ptr1);
    // *ptr1 = 15;  // Error: cannot modify the value of var1 through ptr1
    ptr1 = &var2;  // Allowed: pointer can point to another variable
    printf("const int *ptr1 (after changing pointer): %d\n", *ptr1);

    // 2. int *const ptr: Constant pointer to an integer
    int *const ptr2 = &var2;
    printf("int *const ptr2 (before modification): %d\n", *ptr2);
    *ptr2 = 25;  // Allowed: can modify the value of var2 through ptr2
    printf("int *const ptr2 (after modifying value): %d\n", *ptr2);
    // ptr2 = &var3;  // Error: cannot change the pointer to another variable

    // 3. const int *const ptr: Constant pointer to a constant integer
    const int *const ptr3 = &var3;
    printf("const int *const ptr3: %d\n", *ptr3);
    // *ptr3 = 35;  // Error: cannot modify the value of var3 through ptr3
    // ptr3 = &var1;  // Error: cannot change the pointer to another variable

    return 0;
}





