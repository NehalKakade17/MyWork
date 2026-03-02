package assign4;
import java.util.Scanner;
public class TolBRevManUtil {
    public static Scanner sc = new Scanner(System.in);
    public static TolBRevMan acceptRecord() {
    	System.out.print("Enter the car toll rate (₹): ");
        double carRate = sc.nextDouble();
        
        System.out.print("Enter the truck toll rate (₹): ");
        double truckRate = sc.nextDouble();
        
        System.out.print("Enter the motorcycle toll rate (₹): ");
        double motorcycleRate = sc.nextDouble();
        
        TolBRevMan manager = new TolBRevMan(carRate, truckRate, motorcycleRate);

        System.out.print("Enter the number of cars passing through: ");
        int numCars = sc.nextInt();
        manager.setNumCars(numCars);
        
        System.out.print("Enter the number of trucks passing through: ");
        int numTrucks = sc.nextInt();
        manager.setNumTrucks(numTrucks);
        
        System.out.print("Enter the number of motorcycles passing through: ");
        int numMotorcycles = sc.nextInt();
        manager.setNumMotorcycles(numMotorcycles);

        return manager;
    }
    public static void printRecord(TolBRevMan manager) {
        System.out.println("\nToll Booth Details:");
        System.out.println(manager);
        System.out.printf("Total Vehicles: %d\n", manager.calculateTotalVehicles());
        System.out.printf("Total Revenue: ₹%.2f\n", manager.calculateTotalRevenue());
    }
    public static void menuList() {
        System.out.println("\nMenu:");
        System.out.println("1. Enter Toll Rates and Vehicle Numbers");
        System.out.println("2. Display Toll Booth Information");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }
}

