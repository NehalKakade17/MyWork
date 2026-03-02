import java.util.Scanner;

class Stack2 {
    private int[] stackArray;
    private int top;
    private int capacity;
    public Stack2(int size) {
        stackArray = new int[size];
        capacity = size;
        top = -1;
    }
    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow! Unable to push " + value);
            return;
        }
        stackArray[++top] = value;
    }
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! Unable to pop.");
            return -1;
        }
        return stackArray[top--];
    }
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack = [");
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i]);
            if (i < top) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	System.out.println("Enter size for stack");
	int size = scanner.nextInt();
        Stack2 stack = new Stack2(size);

        while (true) {
            System.out.println("Enter a command (push <number>, pop, display, exit):");
            String command = scanner.nextLine().trim().toLowerCase();

            if (command.startsWith("push")) {
                
                if (command.split(" ").length != 2) {
                    System.out.println("Invalid push command. Usage: push <number>");
                    continue;
                }

                try {
                    int value = Integer.parseInt(command.split(" ")[1]);
                    stack.push(value);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format. Please enter an integer.");
                }
            } else if (command.equals("pop")) {
                int poppedElement = stack.pop();
                if (poppedElement != -1) {
                    System.out.println("Popped element = " + poppedElement);
                }
            } else if (command.equals("display")) {
                stack.display();
            } else if (command.equals("exit")) {
                System.out.println("Exiting the program.");
                break;
            } else {
                System.out.println("Invalid command. Please use push, pop, display, or exit.");
            }
        }

        scanner.close();
    }
}
