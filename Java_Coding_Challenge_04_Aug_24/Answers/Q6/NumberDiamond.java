public class NumberDiamond {
    public static void main(String[] args) {
        int height = 5; // Height of the diamond (number of rows in the upper part)

        // Print the upper part of the diamond
        for (int i = 1; i <= height; i++) {
            // Print leading spaces
            for (int j = height - i; j > 0; j--) {
                System.out.print(" ");
            }

            // Print ascending numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // Print descending numbers
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j);
            }

            // Move to the next line
            System.out.println();
        }

        // Print the lower part of the diamond
        for (int i = height - 1; i > 0; i--) {
            // Print leading spaces
            for (int j = height - i; j > 0; j--) {
                System.out.print(" ");
            }

            // Print ascending numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // Print descending numbers
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j);
            }

            // Move to the next line
            System.out.println();
        }
    }
}
