import java.util.Scanner;

public class InfixToPostfixConverter {

    // Method to check the precedence of operators
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    // Method to convert infix expression to postfix expression
    public static String infixToPostfix(String expression) {
        char[] stack = new char[expression.length()]; // Array to simulate stack
        int top = -1; // Initialize top of stack
        StringBuilder postfix = new StringBuilder(); // StringBuilder for the output

        for (char token : expression.toCharArray()) {
            // Skip spaces
            if (token == ' ') continue;

            // If the token is an operand, add it to the output
            if (Character.isLetterOrDigit(token)) {
                postfix.append(token).append(' ');
            } 
            // If the token is '(', push it to the stack
            else if (token == '(') {
                stack[++top] = token; // Push to stack
            } 
            // If the token is ')', pop from stack until '(' is found
            else if (token == ')') {
                while (top != -1 && stack[top] != '(') {
                    postfix.append(stack[top--]).append(' '); // Pop and append
                }
                top--; // Pop the '('
            } 
            // If the token is an operator
            else {
                while (top != -1 && precedence(stack[top]) >= precedence(token)) {
                    postfix.append(stack[top--]).append(' '); // Pop and append
                }
                stack[++top] = token; // Push the current operator to the stack
            }
        }

        // Pop all the operators from the stack
        while (top != -1) {
            postfix.append(stack[top--]).append(' '); // Pop and append
        }

        return postfix.toString().trim(); // Remove trailing space
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter an infix expression: ");
        String userInput = scanner.nextLine();
        System.out.println("Output: " + infixToPostfix(userInput));

        scanner.close();
    }
}
