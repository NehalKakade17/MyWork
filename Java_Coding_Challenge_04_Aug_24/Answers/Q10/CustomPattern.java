public class CustomPattern {
    public static void main(String[] args) {
        // Define the number of rows for the first part of the pattern
        int initialRows = 4;
        // Define the number of rows for the additional part of the pattern
        int additionalRows = 3;

        // Print the first part of the pattern
        for (int i = 1; i <= initialRows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print((i * j) + " ");
            }
            System.out.println();
        }

        // Print the additional rows
        for (int i = 5; i <= 7; i++) {
            int elementsInRow = 8 - i; // Calculating the number of elements in this part
            for (int j = 1; j <= elementsInRow; j++) {
                System.out.print((i * j) + " ");
            }
            System.out.println();
        }
    }
}


