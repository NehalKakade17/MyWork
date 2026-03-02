import java.util.Scanner;

public class FirstNonRepeatedCharacter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String str = sc.nextLine();
        
        int[] frequency = new int[256];
        countCharacterFrequency(str, frequency, 0);
        
        char result = findFirstNonRepeatedCharacter(str, frequency, 0);
        if (result != '\0') {
            System.out.println(result);
        } else {
            System.out.println("null");
        }
        
        sc.close();
    }
    public static void countCharacterFrequency(String str, int[] frequency, int index) {
        if (index == str.length()) {
            return;
        }

        char currentChar = str.charAt(index);
        frequency[currentChar]++;

        countCharacterFrequency(str, frequency, index + 1);
    }
    public static char findFirstNonRepeatedCharacter(String str, int[] frequency, int index) {
        if (index == str.length()) {
            return '\0';
        }

        char currentChar = str.charAt(index);
        if (frequency[currentChar] == 1) {
            return currentChar;
        }

        return findFirstNonRepeatedCharacter(str, frequency, index + 1); 
    }
}
