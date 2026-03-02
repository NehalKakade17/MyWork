package assign.pending;
import java.util.Scanner;

public class TollBoothRevenueManager {
	static Scanner sc = new Scanner(System.in);
    private double carRate;
    private double truckRate;
    private double motorcycleRate;
    private int numCars;
    private int numTrucks;
    private int numMotorcycles;
    private double totalRevenue;
    public void setTollRates() {
        

        System.out.print("Enter the toll rate for Car (in INR): ");
        carRate = sc.nextDouble();

        System.out.print("Enter the toll rate for Truck (in INR): ");
        truckRate = sc.nextDouble();

        System.out.print("Enter the toll rate for Motorcycle (in INR): ");
        motorcycleRate = sc.nextDouble();
    }
    public void acceptRecord() {
        

        System.out.print("Enter the number of Cars passing through: ");
        numCars = sc.nextInt();

        System.out.print("Enter the number of Trucks passing through: ");
        numTrucks = sc.nextInt();

        System.out.print("Enter the number of Motorcycles passing through: ");
        numMotorcycles = sc.nextInt();
    }
    public void calculateRevenue() {
        totalRevenue = (numCars * carRate) + (numTrucks * truckRate) + (numMotorcycles * motorcycleRate);
    }
    public void printRecord() {
        int totalVehicles = numCars + numTrucks + numMotorcycles;

        System.out.println("Total number of vehicles: " + totalVehicles);
        System.out.printf("Total Revenue Collected: ₹%.2f%n", totalRevenue);
    }
    public static void main(String[] args) {
        TollBoothRevenueManager manager = new TollBoothRevenueManager();
        System.out.println("Set Toll Rates:");
        manager.setTollRates();
        System.out.println("Enter Vehicle Records:");
        manager.acceptRecord();
        manager.calculateRevenue();
        manager.printRecord();
        sc.close();
    }
}

