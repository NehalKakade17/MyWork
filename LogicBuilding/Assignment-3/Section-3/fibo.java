package assign3;

public class fibo {

	public static void main(String[] args) {
		int num = 21;
		int i = 1; int f1 = 0; int f2 = 1;
		System.out.println("fibonacci series:");
		while(i<=num) {
			System.out.print(f1+" ");
			int next = f1 + f2;
			f1 = f2;
			f2 = next;
			i++;
		}
		

	}

}
