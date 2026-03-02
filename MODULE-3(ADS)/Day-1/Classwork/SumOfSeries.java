import java.util.*;
class SumOfSeries{
	public static double sumSeries(int n){
		if(n==1){
			return 1.0;
		}
		return (n% 2 == 0? -1.0/n : 1.0/n) + sumSeries(n-1);
	}
	public static void main(String[] args){
		Scanner sc =new Scanner(System.in);
		System.out.print("Enter number: ");
		int num = sc.nextInt();
		double result = sumSeries(num);
		System.out.println(result);
	}
}