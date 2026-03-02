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
#include <math.h>

// Function to calculate the distance between two points
float calculateDistance(float x1, float y1, float x2, float y2) {
    return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
}

int main() {
    // Declare variables to store coordinates
    float x1, y1, x2, y2;

    // Input the coordinates of the first point
    printf("Enter coordinates of the first point (x1 y1): ");
    fflush(stdout);  // Force output to be displayed immediately
    int inputResult1 = scanf("%f %f", &x1, &y1);
    if (inputResult1 != 2) {
        printf("Invalid input. Please enter two floating-point values.\n");
        return 1;
    }

    // Clean the input buffer (necessary in case of extra characters like newline)
    getchar();

    // Input the coordinates of the second point
    printf("Enter coordinates of the second point (x2 y2): ");
    fflush(stdout);  // Force output to be displayed immediately
    int inputResult2 = scanf("%f %f", &x2, &y2);
    if (inputResult2 != 2) {
        printf("Invalid input. Please enter two floating-point values.\n");
        return 1;
    }

    // Calculate the distance between the two points
    float distance = calculateDistance(x1, y1, x2, y2);

    // Output the result
    printf("The distance between the points (%.2f, %.2f) and (%.2f, %.2f) is: %.2f\n",
           x1, y1, x2, y2, distance);
    fflush(stdout);  // Force output to be displayed immediately

    return 0;
}



















