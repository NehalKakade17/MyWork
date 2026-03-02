class DoublyLinkedList{
	Node head;
	static class Node{
		int data;
		Node next;
		Node prev;
	
		Node(int d){
			data = d;
			next = null;
			prev = null;
		}
	}
	public void insert(int data){
		Node newNode = new Node(data);
		newNode.next = head;
		newNode.prev = null;
		if(head != null){
			head.prev = newNode;
		}
		head = newNode;
	}
	void display(Node n){
		Node p =null;
		while( n != null){
			System.out.print(n.data+"---->");
			p=n;
			n = n.next;
		}
		System.out.println();
		while(p != null){
			System.out.print(p.data+"<----");
			p = p.prev;
		}
		
	}
	void insertAfter(Node prev_node,int data){
		if( prev_node == null){
			System.out.println("Node Not Found");
			return;
		}
		Node new_node = new Node(data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;
		new_node.prev = prev_node;
		if(new_node.next != null){
			new_node.next.prev = new_node;
		}
		
	}
	void delete(Node del){
		if(head==null || del==null){
			return;
		}
		if(head==del){
			head = del.next;
		}
		if(del.next != null){
			del.next.prev = del.prev;
		}
		if(del.prev != null){
			del.prev.next = del.next;
		}
		return;
	}
	public static void main(String[] args){
		DoublyLinkedList list = new DoublyLinkedList();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.insertAfter(list.head.next.next,80);
		list.delete(list.head.next);
		list.display(list.head);
		
	}
}