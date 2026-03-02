public class PalindromeNumberPyramid {
    public static void main(String[] args) {
        int height = 5; // Height of the pyramid

        // Loop through each level of the pyramid
        for (int i = 1; i <= height; i++) {
            // Print leading spaces
            for (int j = 0; j < height - i; j++) {
                System.out.print(" ");
            }
            
            // Print ascending part of the palindrome
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            
            // Print descending part of the palindrome
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j);
            }
            
            // Move to the next line
            System.out.println();
        }
    }
}
