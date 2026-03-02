//============================================================================
// Name        : Asssignment-2(Q3).cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

class TollBooth {
private:
    int totalVehicles;   // Number of vehicles passed through the booth
    double totalRevenue; // Total revenue collected

public:
    // Constructor to initialize the data members
    TollBooth() {
        totalVehicles = 0;
        totalRevenue = 0.0;
    }

    // Resets the toll booth statistics
    void reset() {
        totalVehicles = 0;
        totalRevenue = 0.0;
        cout << "Booth statistics have been reset." << endl;
    }

    // Accepts a vehicle type and toll amount, updates the statistics
    void vehiclePayingToll(int vehicleType, double tollAmount) {
        totalVehicles++;            // Increment total vehicles
        totalRevenue += tollAmount; // Add toll amount to total revenue

        // Output specific details based on vehicle type
        if (vehicleType == 1) {
            cout << "Standard car passed. Toll collected: $" << tollAmount << endl;
        } else if (vehicleType == 2) {
            cout << "Truck passed. Toll collected: $" << tollAmount << endl;
        } else if (vehicleType == 3) {
            cout << "Bus passed. Toll collected: $" << tollAmount << endl;
        } else {
            cout << "Invalid vehicle type!" << endl;
        }
    }

    // Getter for totalVehicles
    int getTotalVehicles() {
        return totalVehicles;
    }

    // Getter for totalRevenue
    double getTotalRevenue() {
        return totalRevenue;
    }
};

int main() {
    TollBooth booth;
    int choice;


    // Fixed toll amounts for different vehicle types
    const double standardCarToll = 2.0;
    const double truckToll = 5.0;
    const double busToll = 10.0;

    while (true) {
        cout << "\nMenu:\n";
        cout << "1. Add a standard car and collect toll\n";
        cout << "2. Add a truck and collect toll\n";
        cout << "3. Add a bus and collect toll\n";
        cout << "4. Display total cars passed\n";
        cout << "5. Display total revenue collected\n";
        cout << "6. Reset booth statistics\n";
        cout << "7. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1:
                booth.vehiclePayingToll(1, standardCarToll); // Standard car toll
                break;
            case 2:
                booth.vehiclePayingToll(2, truckToll); // Truck toll
                break;
            case 3:
                booth.vehiclePayingToll(3, busToll); // Bus toll
                break;
            case 4:
                cout << "Total vehicles passed: " << booth.getTotalVehicles() << endl;
                break;
            case 5:
                cout << "Total revenue collected: $" << booth.getTotalRevenue() << endl;
                break;
            case 6:
                booth.reset(); // Reset the statistics
                break;
            case 7:
                cout << "Exiting the program.\n";
                return 0; // Exit the program
            default:
                cout << "Invalid choice! Please try again.\n";
                break;
        }
    }

    return 0;
}

