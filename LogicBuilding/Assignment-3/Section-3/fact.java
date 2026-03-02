package assign3;

public class fact {

	public static void main(String[] args) {
		
		int num = 10;
		int n = 1;
		for(int i=1;i<=num;i++) {
			n = n*i;
	}
		System.out.println("The factorial of "+num+" is " +n);
}
}