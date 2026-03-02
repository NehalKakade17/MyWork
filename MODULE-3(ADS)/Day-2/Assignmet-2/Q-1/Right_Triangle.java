
import java.util.*;

public class Right_Triangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        printTriangle(n, 0);
        sc.close();
    }
    public static void printTriangle(int n, int i) {
        if (i >= n) {
            return;
        }
        printStars(i + 1);
        printTriangle(n, i + 1);
    }
    public static void printStars(int count) {
        for (int j = 0; j < count; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}

