public class PatternGenerator {
    public static void main(String[] args) {
        // Loop to create each line of the pattern
        for (int i = 1; i <= 9; i++) {
            // Generate the number 'n' which is a sequence of increasing digits
            StringBuilder n = new StringBuilder();
            for (int j = 1; j <= i; j++) {
                n.append(j);
            }
            
            // Convert 'n' to an integer
            int num = Integer.parseInt(n.toString());
            
            // Calculate the result of num * 8 + i
            int result = num * 8 + i;
            
            // Generate the expected pattern output
            StringBuilder pattern = new StringBuilder();
            for (int k = 9; k >= 10 - i; k--) {
                pattern.append(k);
            }
            
            // Print the result
            System.out.println(num + " x 8 + " + i + " = " + pattern);
        }
    }
}
