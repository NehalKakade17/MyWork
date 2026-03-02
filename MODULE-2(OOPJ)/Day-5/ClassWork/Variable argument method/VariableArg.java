package selfstudy;

public class VariableArg {
	public static void Sum(int... arr) { //variable argument method/variable arity method
		int res = 0;
		for(int ele : arr) {
			res = ele+res;
		}
		System.out.println("The sum is: "+res);
	}
	public static void main(String[] args) {
		VariableArg.Sum(10,11);
		VariableArg.Sum(4,88,19);
		VariableArg.Sum(15,61,86,23,90);
		VariableArg.Sum(90);

	}

}
