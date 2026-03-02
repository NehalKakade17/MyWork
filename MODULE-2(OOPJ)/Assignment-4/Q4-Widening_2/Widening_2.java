package homework;

public class Widening_2 {

	public static void main(String[] args) {
		int intValue = 42;
        double doubleValue = intValue;
        System.out.println("Widening conversion from int to double: " + doubleValue);
        float floatValue = intValue;
        System.out.println("Widening conversion from int to float: " + floatValue);
        String stringValue = Integer.toString(intValue);
        System.out.println("Widening conversion from int to String: " + stringValue);


	}

}
