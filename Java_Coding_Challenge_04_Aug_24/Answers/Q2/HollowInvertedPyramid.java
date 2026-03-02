public class HollowInvertedPyramid {
    public static void main(String[] args) {
        int height = 5; // Height of the pyramid
        
        // Loop through each level of the pyramid
        for (int i = 0; i < height; i++) {
            // Print leading spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            
            // Print the asterisks and spaces
            for (int j = 0; j < 2 * (height - i) - 1; j++) {
                if (j == 0 || j == 2 * (height - i) - 2 || i == 0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            
            // Move to the next line
            System.out.println();
        }
    }
}
