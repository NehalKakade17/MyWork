package assign2;
import java.util.*;
public class Vote {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your age:");
		int age = sc.nextInt();
		if(age>=18) {
			System.out.println("You are eligile to vote");
		}
		else {
			System.out.println("You are not eligile to vote");
		}

	}

}
