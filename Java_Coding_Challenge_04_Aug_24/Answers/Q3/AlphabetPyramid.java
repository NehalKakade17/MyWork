public class AlphabetPyramid {
    public static void main(String[] args) {
        int height = 5; // Height of the pyramid
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Characters to use
        int charIndex = 0; // Index to track the current character in the string

        // Loop through each level of the pyramid
        for (int i = 0; i < height; i++) {
            // Print leading spaces
            for (int j = 0; j < height - i - 1; j++) {
                System.out.print(" ");
            }
            
            // Print characters for this row
            for (int j = 0; j < (2 * i + 1); j++) {
                // Print the current character
                System.out.print(characters.charAt(charIndex));
                charIndex++;
                
                // Print a space if it's not the last character of the row
                if (j < (2 * i)) {
                    System.out.print(" ");
                }
                
                // Wrap around if the index exceeds the length of the characters string
                if (charIndex >= characters.length()) {
                    charIndex = 0;
                }
            }
            
            // Move to the next line
            System.out.println();
}
    }
}
