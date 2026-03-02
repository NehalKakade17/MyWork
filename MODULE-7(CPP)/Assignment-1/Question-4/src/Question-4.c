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

    // i. Pointer to a const value
    const int *ptr1 = &var1;  // Pointer to a const value
    // ptr1 points to var1, but the value of var1 cannot be modified through ptr1
    printf("Pointer to const value: %d\n", *ptr1);
    // *ptr1 = 15;  // This would give an error: "assignment of read-only location"
    ptr1 = &var2;  // The pointer can point to another variable
    printf("Pointer to const value (after changing pointer): %d\n", *ptr1);

    // ii. Const pointer to a value
    int * const ptr2 = &var2;  // Const pointer to a value
    // ptr2 itself cannot be reassigned, but the value of var2 can be modified
    printf("Const pointer to value: %d\n", *ptr2);
    *ptr2 = 25;  // The value of var2 can be modified through ptr2
    printf("After modifying var2 through ptr2: %d\n", *ptr2);
    // ptr2 = &var3;  // This would give an error: "assignment of read-only variable"

    // iii. Const pointer to a const value
    const int * const ptr3 = &var3;  // Const pointer to a const value
    // Neither the pointer nor the value it points to can be modified
    printf("Const pointer to const value: %d\n", *ptr3);
    // *ptr3 = 35;  // This would give an error: "assignment of read-only location"
    // ptr3 = &var1;  // This would give an error: "assignment of read-only variable"

    return 0;
}




