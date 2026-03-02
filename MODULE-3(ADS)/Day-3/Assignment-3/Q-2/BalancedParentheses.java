import java.util.Scanner;

public class BalancedParentheses {

    // Method to check if the parentheses are balanced
    public static String isBalanced(String expression) {
        int maxSize = expression.length();
        char[] stack = new char[maxSize]; // Array to simulate stack
        int top = -1; // Initialize top of stack

        // Iterate through each character in the expression
        for (char ch : expression.toCharArray()) {
            // If it's an opening bracket, push to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack[++top] = ch; // Push element and increment top
            } 
            // If it's a closing bracket, check for matching
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If stack is empty or top of stack doesn't match, it's not balanced
                if (top == -1) {
                    return "Not Balanced";
                }
                char topChar = stack[top--]; // Pop the top element

                if (!isMatchingPair(topChar, ch)) {
                    return "Not Balanced";
                }
            }
        }

        // If stack is empty, all opening brackets were matched
        return top == -1 ? "Balanced" : "Not Balanced";
    }

    // Helper method to check if the brackets are a matching pair
    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
               (opening == '{' && closing == '}') ||
               (opening == '[' && closing == ']');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for input
        System.out.print("Enter a string of parentheses: ");
        String userInput = scanner.nextLine();

        // Check if the parentheses in the input string are balanced
        String result = isBalanced(userInput);
        System.out.println("Input: " + userInput);
        System.out.println("Output: " + result);

        scanner.close();
    }
}
