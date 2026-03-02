import java.util.Scanner;

public class PostfixEvaluator {

    // Method to evaluate a postfix expression
    public static int evaluatePostfix(String expression) {
        char[] tokens = expression.toCharArray();
        int[] stack = new int[tokens.length]; // Array to simulate stack
        int top = -1; // Initialize top of stack

        for (char token : tokens) {
            // Skip spaces
            if (token == ' ') continue;

            // If the token is a number, push it onto the stack
            if (Character.isDigit(token)) {
                stack[++top] = token - '0'; // Convert char to int and push
            } 
            // If the token is an operator, pop two operands and apply the operator
            else {
                int operand2 = stack[top--]; // Pop top element
                int operand1 = stack[top--]; // Pop next element
                int result = 0;

                switch (token) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                }
                stack[++top] = result; // Push result back to stack
            }
        }
        // The final result will be at the top of the stack
        return stack[top];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a postfix expression: ");
        String userInput = scanner.nextLine();
        System.out.println("Output: " + evaluatePostfix(userInput));

        scanner.close();
    }
}
