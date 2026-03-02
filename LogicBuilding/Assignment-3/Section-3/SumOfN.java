package assign3;
import java.util.*;
public class SumOfN {
	void sum(int n){
		int result = 0;
		for(int i=0;i<=n;i++) {
			result += i;
		}
		System.out.println(result);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumOfN s =new SumOfN();
		s.sum(50);

	}

}
