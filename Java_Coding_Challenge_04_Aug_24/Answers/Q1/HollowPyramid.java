public class HollowPyramid {
    public static void main(String[] args) {
        int rows = 5; // You can change this value to adjust the height of the pyramid

        for (int i = 1; i <= rows; i++) {
            // Print leading spaces
            for (int j = 1; j <= (rows - i); j++) {
                System.out.print(" ");
            }

            // Print the pyramid structure
            for (int k = 1; k <= (2 * i - 1); k++) {
                if (k == 1 || k == (2 * i - 1) || i == rows) {
                    // Print '*' for the first and last positions in each row and for the last row
                    System.out.print("*");
                } else {
                    // Print ' ' (space) for hollow part
                    System.out.print(" ");
                }
            }

            // Move to the next line after each row
            System.out.println();
        }
    }
}