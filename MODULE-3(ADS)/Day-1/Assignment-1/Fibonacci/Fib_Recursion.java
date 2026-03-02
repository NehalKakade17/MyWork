class Fib_Recursion{
	static int fib(int num){
		if(num<=1){
			return 1;
		}
		else{
			return fib(num-1)+fib(num-2);
		}
	}
	public static void main(String[] args){ 
		int num =10;
		for(int i=0;i<num;i++){
			System.out.print(fib(i)+" ");
		}
	}
}