import java.util.Scanner;

public class RemovePunctuation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String result = removePunctuation(input);
        System.out.println("String without punctuation: " + result);
        
        scanner.close(); 
    }
    private static String removePunctuation(String str) {
        if (str.isEmpty()) {
            return "";
        }
        char firstChar = str.charAt(0);
        if (isPunctuation(firstChar)) {
           
            return removePunctuation(str.substring(1));
        } else {
            
            return firstChar + removePunctuation(str.substring(1));
        }
    }

  
    private static boolean isPunctuation(char ch) {
        return !Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch);
    }
}
