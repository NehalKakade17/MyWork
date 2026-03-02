package assign4;
public class TolBRevMan {
    private double carR;
    private double truckR;
    private double motorcycleR;
    private int numCars;
    private int numTrucks;
    private int numMotorcycles;

    public TolBRevMan(double carR, double truckR, double motorcycleR) {
        this.carR = carR;
        this.truckR = truckR;
        this.motorcycleR = motorcycleR;
        this.numCars = 0;
        this.numTrucks = 0;
        this.numMotorcycles = 0;
    }
    public double getCarRate() {
        return carR;
    }

    public void setCarRate(double carR) {
        this.carR = carR;
    }

    public double getTruckRate() {
        return truckR;
    }

    public void setTruckRate(double truckR) {
        this.truckR = truckR;
    }

    public double getMotorcycleRate() {
        return motorcycleR;
    }

    public void setMotorcycleRate(double motorcycleR) {
        this.motorcycleR = motorcycleR;
    }

    public int getNumCars() {
        return numCars;
    }

    public void setNumCars(int numCars) {
        this.numCars = numCars;
    }

    public int getNumTrucks() {
        return numTrucks;
    }

    public void setNumTrucks(int numTrucks) {
        this.numTrucks = numTrucks;
    }

    public int getNumMotorcycles() {
        return numMotorcycles;
    }

    public void setNumMotorcycles(int numMotorcycles) {
        this.numMotorcycles = numMotorcycles;
    }
    public double calculateTotalRevenue() {
        return (numCars * carR) + (numTrucks * truckR) + (numMotorcycles * motorcycleR);
    }
    public int calculateTotalVehicles() {
        return numCars + numTrucks + numMotorcycles;
    }

    @Override
    public String toString() {
        return String.format("Car Rate: ₹%.2f\nTruck Rate: ₹%.2f\nMotorcycle Rate: ₹%.2f\nNumber of Cars: %d\nNumber of Trucks: %d\nNumber of Motorcycles: %d",
                             carR, truckR, motorcycleR, numCars, numTrucks, numMotorcycles);
    }
}

