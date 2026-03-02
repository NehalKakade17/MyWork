public class NumberTrianglePattern {
    public static void main(String[] args) {
        int rows = 5; // Number of rows for the pattern

        // Loop through each row
        for (int i = 1; i <= rows; i++) {
            // Print ascending numbers on the left
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // Print spaces to align the descending numbers
            for (int k = rows - i; k > 0; k--) {
                System.out.print(" ");
            }

            // Print descending numbers on the right
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }

            // Move to the next line
            System.out.println();
        }
    }
}
