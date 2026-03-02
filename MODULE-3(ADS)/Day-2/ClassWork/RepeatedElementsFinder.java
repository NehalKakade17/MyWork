import java.util.Scanner;

public class RepeatedElementsFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Repeated elements in the array:");
        findRepeatedElements(arr, n, 0, new boolean[n], new boolean[n]);
        
        scanner.close();
    }
    private static void findRepeatedElements(int[] arr, int n, int index, boolean[] seen, boolean[] repeated){
        if (index == n) {
            return;
        }
        if (seen[arr[index]]) {
                if (!repeated[arr[index]]) {
                System.out.println(arr[index]);
                repeated[arr[index]] = true;
            }
        } else {
            seen[arr[index]] = true;
        }
        findRepeatedElements(arr, n, index + 1, seen, repeated);
    }
}
