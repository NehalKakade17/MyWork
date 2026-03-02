import java.util.Scanner;

public class RemoveWhitespace {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String result = removeWhitespace(input);
        System.out.println("String after removing whitespaces: \"" + result + "\"");
        sc.close();
    }
    public static String removeWhitespace(String str) {
        if (str.isEmpty()) {
            return "";
        }
        char firstChar = str.charAt(0);
        if (Character.isWhitespace(firstChar)) {
            return removeWhitespace(str.substring(1));
        } else {
            return firstChar + removeWhitespace(str.substring(1));
        }
    }
}

