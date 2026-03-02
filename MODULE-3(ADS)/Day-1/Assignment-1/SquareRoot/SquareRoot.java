import java.text.DecimalFormat;
import java.util.*;
public class SquareRoot {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	 System.out.print("Enter number: ");
        double number = sc.nextInt();
        double precision = 0.0001;
        double sqrt = sqrt(number, number / 2, precision);
	DecimalFormat df = new DecimalFormat("#.#");
        System.out.println(df.format(sqrt));
    }

    public static double sqrt(double number, double guess, double precision) {
        if (Math.abs(guess * guess - number) < precision) { 
            return guess;
        }
        double newNum = (guess + number / guess) / 2;
        return sqrt(number, newNum, precision);
    }
}
