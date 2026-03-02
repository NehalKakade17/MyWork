import java.util.*;
public class GCD {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	System.out.print("a= ");
	int a = sc.nextInt();
	System.out.print("b= ");
        int b = sc.nextInt();
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd(a, b));
	sc.close();
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
