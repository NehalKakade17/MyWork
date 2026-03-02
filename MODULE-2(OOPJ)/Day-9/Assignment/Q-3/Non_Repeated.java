package collectionsproblem;
import java.util.*;
public class Non_Repeated {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter any string:");
		String input = sc.nextLine().trim();
        char result = findFirstNonRepeatedCharacter(input);

        if (result != Character.MIN_VALUE) {
            System.out.println("First non-repeated character: " + result);
        } else {
            System.out.println("No non-repeated character found.");
        }
        sc.close();
    }

    private static char findFirstNonRepeatedCharacter(String input) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        for (char c : input.toCharArray()) {
            if (charCountMap.get(c) == 1) {
                return c; 
            }
        }

        return Character.MIN_VALUE; 

	}

}
