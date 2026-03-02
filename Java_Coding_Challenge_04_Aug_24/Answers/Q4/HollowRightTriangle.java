public class HollowRightTriangle {
    public static void main(String[] args) {
        int height = 5; // Height of the triangle

        // Loop through each row of the triangle
        for (int i = 1; i <= height; i++) {
            // Print numbers and spaces for each row
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i || i == height) {
                    // Print numbers on the edges and the base
                    System.out.print(j + " ");
                } else {
                    // Print spaces inside the triangle
                    System.out.print("  ");
                }
            }
            // Move to the next line
            System.out.println();
        }
    }
}