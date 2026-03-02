import java.util.Scanner;

public class ReverseWords {
    public static String reverseWords(String sentence) {
        // Base case: if the sentence is empty or has no spaces, return it
        if (sentence.isEmpty()) {
            return sentence;
        }
        int lastSpaceIndex = sentence.lastIndexOf(' ');
        if (lastSpaceIndex == -1) {
            return sentence;
        }
        String lastWord = sentence.substring(lastSpaceIndex + 1);
        String remainingSentence = sentence.substring(0, lastSpaceIndex);
        return lastWord + " " + reverseWords(remainingSentence);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        String result = reverseWords(sentence);
        System.out.println("Reversed sentence: " + result);
        sc.close();
    }
}
