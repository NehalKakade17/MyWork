import java.util.*;
public class RepeatedCharacters {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a String; ");
        String str = sc.nextLine();
        int[] frequency = new int[256];
        findRepeatedCharacters(str, frequency, 0);
        char[] repeatedChars = new char[256];
	int count = 0;
        for (char ch = 0; ch < frequency.length; ch++) {
            if (frequency[ch] > 1) {
                repeatedChars[count++] = ch;
            }
        }
        
        System.out.print("[ ");
        for (int i = 0; i < count; i++) {
            System.out.print("'"+repeatedChars[i]+"'");
            if (i < count - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(" ]");

        sc.close();
           
    }

    public static void findRepeatedCharacters(String str, int[] frequency, int index) {
        if (index == str.length()) { 
            return;
        }

        char currentChar = str.charAt(index);
        frequency[currentChar]++; 
        
        findRepeatedCharacters(str, frequency, index + 1);
    }

    }
