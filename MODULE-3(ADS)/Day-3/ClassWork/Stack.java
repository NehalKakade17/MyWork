class Stack{
	static final int MAX = 10;
	int top;
	int [] arr = new int[MAX];
	Stack(){
		top = -1;
	}
	boolean isEmpty(){
		return (top<0);
	}
	boolean push(int n){
		if(top>=MAX-1){
			System.out.println("Stack FULL");
			return false;
		}
		arr[++top] = n;
		return true;
	}
	int pop(){
		if(top<0){
			System.out.println("Stack Empty");
			return 0;
		}
		return arr[top--];
	}
	int peek(){
		return (top<0)? -1: arr[top];
	}
	void display(){
		if(isEmpty()){
			System.out.println("Empty stack!");
		}
		else{
			System.out.println("Stack elements are:");
			show(top);
			System.out.println();
		}
	}
	void show(int index){
		if(index<0)
			return;
		System.out.println(arr[index] + "");
		show(index-1);
	}
	public static void main(String args[])
	{
		Stack s1 = new Stack();
		s1.push(10);
		s1.push(20);
		s1.push(30);
		
		s1. display();
		
		s1.pop();
		s1. display();
		int peek = s1.peek();
		System.out.println("Top element: "+peek);
		
	}
}