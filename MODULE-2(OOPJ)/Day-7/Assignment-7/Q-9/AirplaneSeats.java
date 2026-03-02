package homework;
import java.util.Scanner;

public class AirplaneSeats {
    private boolean[][] seats;
    private int rows;
    private int cols;
    public AirplaneSeats(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        seats = new boolean[rows][cols];
    }
    public boolean bookSeat(int row, int col) {
        if (isValidSeat(row, col)) {
            if (!seats[row][col]) { 
                seats[row][col] = true;
                return true;
            } else {
                System.out.println("Seat already booked.");
            }
        } else {
            System.out.println("Invalid seat position.");
        }
        return false;
    }
    public boolean cancelBooking(int row, int col) {
        if (isValidSeat(row, col)) {
            if (seats[row][col]) { 
                seats[row][col] = false; 
                return true;
            } else {
                System.out.println("Seat is already available.");
            }
        } else {
            System.out.println("Invalid seat position.");
        }
        return false;
    }
    public boolean isSeatAvailable(int row, int col) {
        if (isValidSeat(row, col)) {
            return !seats[row][col]; 
        } else {
            System.out.println("Invalid seat position.");
            return false;
        }
    }
    public void displaySeatingChart() {
        System.out.println("Seating Chart:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (seats[i][j]) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
    private boolean isValidSeat(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        AirplaneSeats airplane = new AirplaneSeats(rows, cols);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Book a seat");
            System.out.println("2. Cancel a booking");
            System.out.println("3. Check seat availability");
            System.out.println("4. Display seating chart");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter row to book (0-based index): ");
                    int bookRow = sc.nextInt();
                    System.out.print("Enter column to book (0-based index): ");
                    int bookCol = sc.nextInt();
                    if (airplane.bookSeat(bookRow, bookCol)) {
                        System.out.println("Seat booked successfully.");
                    }
                    break;
                case 2:
                    System.out.print("Enter row to cancel (0-based index): ");
                    int cancelRow = sc.nextInt();
                    System.out.print("Enter column to cancel (0-based index): ");
                    int cancelCol = sc.nextInt();
                    if (airplane.cancelBooking(cancelRow, cancelCol)) {
                        System.out.println("Booking cancelled successfully.");
                    }
                    break;
                case 3:
                    System.out.print("Enter row to check (0-based index): ");
                    int checkRow = sc.nextInt();
                    System.out.print("Enter column to check (0-based index): ");
                    int checkCol = sc.nextInt();
                    if (airplane.isSeatAvailable(checkRow, checkCol)) {
                        System.out.println("Seat is available.");
                    } else {
                        System.out.println("Seat is occupied.");
                    }
                    break;
                case 4:
                    airplane.displaySeatingChart();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

