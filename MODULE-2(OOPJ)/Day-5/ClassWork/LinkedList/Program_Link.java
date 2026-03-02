package selfstudy;
class Node{
	int data;
	Node next = null;
	Node(int data){
		this.data = data;
	}
}
class LinkedList{
	private Node head = null;
	private Node tail = null;
	public boolean isEmpty() {
		return this.head == null;
	}
	public void addFirst(int data) {
		Node newnode = new Node(data);
		if(this.isEmpty()) {
			this.tail = newnode;
		}
		else {
			newnode.next = this.head;
		}
		this.head = newnode;
	}
	public void addLast(int data) {
		Node newnode = new Node(data);
		if(this.isEmpty()) {
			this.head = newnode;
		}
		else {
			this.tail.next = newnode;
		}
		this.tail = newnode;
	}
	public void printList() {
		if(!this.isEmpty()) {
			Node trav = this.head;
			while(trav != null) {
				System.out.print(trav.data+" ");
				trav = trav.next;
			}
			System.out.println();
		}
		else {
			System.out.println("List is Empty..");
		}
	}
}
public class Program_Link {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addFirst(30);
		list.addFirst(70);
		list.addFirst(80);
		list.addFirst(20);
		list.addLast(100);
		list.addLast(45);
		list.printList();

	}

}
