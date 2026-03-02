class Queue{
	int size = 5;
	int[] Q = new int[size];
	int front,rear;
	Queue(){
		front = -1;
		rear = -1;
	}
	boolean isFull(){
		return (rear==size-1);		
	}
	boolean isEmpty(){
		return (front == -1);		
	}
	void enqueue(int value){
		if(isFull()){
			System.out.println("Queue Full");
		}
		else{
			if(front == -1){
				front = 0;
			}
			rear++;
			Q[rear] = value;
			System.out.println(value+" inserted");
		}
	}
	int dequeue(){
		if(isEmpty()){
			System.out.println(" Queue Empty");
			return -1;
		}
		else{
			int x = Q[front];
			System.out.println(x+ " Deleted");
			if (front > rear)
			{
				front = -1;
				rear = -1;
			}
			else{
				front++;
			}
			return x;
		}
	}
	void display(){
		if(isEmpty()){
			System.out.println("Queue Empty");
		}
		for(int i = front;i<=rear;i++){
			System.out.print(Q[i]+ " ");
		}
		System.out.println();
	}
	public static void main(String[] args){
		Queue q = new Queue();
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(8);
		q.display();
		q.dequeue();
		q.display();

	}
}