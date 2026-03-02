package assign2;
import java.util.*;
public class Season {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any integer from 1-12:");
		int s = sc.nextInt();
		switch(s){
		case 1:
		case 10:
		case 11:
		case 12:
			System.out.println("It is Winter!");
			break;
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("It is Summer!");
			break;
		case 6:
		case 7:
		case 8:
		case 9:
			System.out.println("It is Rainy Season!");
			break;
		default:
			System.out.println("Enter number in given range");
			break;
		}
	}

}
