import java.util.Scanner;

public class ReverseStringUsingStack {

    // Method to reverse a string using a stack
    public static String reverseString(String input) {
        int n = input.length();
        char[] stack = new char[n]; // Array to simulate stack
        int top = -1; // Initialize top of stack

        // Push each character onto the stack
        for (char ch : input.toCharArray()) {
            stack[++top] = ch; // Push character to stack
        }

        // Pop characters from the stack to form the reversed string
        StringBuilder reversed = new StringBuilder();
        while (top != -1) {
            reversed.append(stack[top--]); // Pop character and append to reversed string
        }

        return reversed.toString(); // Convert StringBuilder to String
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter a string to reverse: ");
        String userInput = scanner.nextLine();

        // Reverse the string and display the output
        String reversedString = reverseString(userInput);
        System.out.println("Input: " + userInput);
        System.out.println("Output: " + reversedString);

        scanner.close();
    }
}
