class LinkedList{
	Node head;
	static class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	public void display(){
		Node n =head;
		while(n != null){
			System.out.print(n.data+"----> ");
			n = n.next;
		}
	}
	public void insertFirst(int newnode){
		Node newN = new Node(newnode);
		newN.next = head;
		head = newN;
	}
	public void insertAfter( Node prevnode,int newnode){
		Node newN = new Node(newnode);
		newN.next = prevnode.next;
		prevnode.next = newN;
	}
	public void insertEnd(int data){
		Node newNode = new Node(data);
		if(head == null){
			head = new Node(data);
			return;
		}
		newNode.next = null;
		Node last = head;
		while(last.next != null){
			last = last.next;
		}
		last.next = newNode;
		return;
	}
	public void delete(int data){
		Node temp =head,prev = null;
		if(temp != null && temp.data == data){
			head = temp.next;
			return;
		}
		while(temp != null && temp.data != data){
			prev = temp;
			temp = temp.next;
		}
		if(temp == null){
			return;
		}
		prev.next = temp.next;
	}
	public void deletePosition(int pos){
		if(head==null){
			return;
		}
		Node temp = head;
		if(pos == 0){
			head = temp.next;
			return;
		}
		for(int i =0; temp != null && i<pos-1;i++){
			temp = temp.next;
		}
		if(temp == null || temp.next == null){
			return;
		}
		Node n = temp.next.next;
		temp.next = n;
	}
	public int count(){
		Node temp = head;
		int c =0;
		while(temp != null){
			c++;
			temp = temp.next;
		}
		return c;
	}
	public boolean search(Node head,int val){
		Node n = head;
		while(n != null){
			if(n.data == val){
				return true;
			}
			n = n.next;
		}
		return false;
	}
	public Node Reverse(Node n){
		
		Node prev = null;
		Node curr = n;
		Node next = null;
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		n = prev;
		return n;
	}
	public void middle(){
		Node ptr1 = head;
		Node ptr2 = head;
		while(ptr2 != null && ptr2.next != null){
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
		}
		System.out.print("Middle- "+ptr1.data);
	}

	public static void main(String[] args){
		LinkedList list = new LinkedList();
		list.head = new Node(10);
		Node second = new Node(20);
		Node third = new Node(30);
		list.head.next = second;
		second.next = third;
		list.display();
		System.out.println();
		list.insertFirst(50);
		list.display();
		System.out.println();
		list.insertAfter(list.head.next.next,80);
		list.display();
		System.out.println();
		list.insertEnd(90);
		list.display();
		System.out.println();
		list.delete(20);
		list.display();
		System.out.println();
		list.delete(76);
		list.display();
		System.out.println();
		list.delete(50);
		list.display();
		System.out.println();
		list.insertAfter(list.head.next.next,60);
		list.display();
		System.out.println();
		list.deletePosition(2);
		list.display();
		System.out.println();
		System.out.println("Count- "+list.count());
		System.out.println();
		System.out.println("Is 60 present - "+list.search(list.head,60));
		list.head = list.Reverse(list.head);
		list.display();
		System.out.println();
		list.middle();
		
	}
}