import java.util.Scanner;

public class Reverse {

    public static String reverseString(String s) {
        if (s.isEmpty()) {
            return s;
        }
        return s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.nextLine();
        String result = reverseString(str);		
        System.out.println("Reversed String: " + result);
        sc.close();
    }
}
