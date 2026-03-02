class BT{
	Node root;
	static class Node{
		int data;
		Node left,right;
		Node(int d){
			data = d;
			left = right = null;
		}
	}
	BT(){
		root = null;
	}
	BT(int d){
		root = new Node(d);
	}
	public void inorderPrint(Node n){
		if(n==null){
			return;
		}
		inorderPrint(n.left);
		System.out.print(n.data+" ");
		inorderPrint(n.right);
	}
	public void inorder(){
		inorderPrint(root);
	}
	public void printPreorder(Node n){
		if(n==null){
			return;
		}
		System.out.print(n.data+" ");
		printPreorder(n.left);
		printPreorder(n.right);
	}
	public void preorder(){
		printPreorder(root);
	}
	public void printPostorder(Node n){
		if(n == null){
			return;
		}
		printPostorder(n.left);
		printPostorder(n.right);
		System.out.print(n.data+" ");
	}
	public void postorder(){
		printPostorder(root);
	}
	public Node delete(Node root,int data){
		if(root == null){
			return root;
		}
		if(data < root.data){
			root.left = delete(root.left,data);
		}
		else if(data > root.data){
			root.right = delete(root.right,data);
		}
		else{
			if(root.left == null && root.right == null){
				return null;
			}
			if(root.left == null){
				return root.right;
			}
			else if(root.right == null){
				return root.left;
			}
			root.data = minValue(root.right);
			root.right = delete(root.right,root.data);

		}
		return root;

	}
	public int minValue(Node n){
		int x = n.data;
		while(n.left != null){
			x = n.left.data;
			n = n.left;
		}
		return x;
	}
	void printdelete(int data)
	{
		root = delete(root, data);
	}
	public static void main(String[] args){
		BT tree = new BT();
		tree.root = new Node(17);
		tree.root.left = new Node(12);
		tree.root.left.left = new Node(10);
		tree.root.left.right = new Node(15);
		tree.root.right = new Node(20);
		tree.root.right.right = new Node(22);
		tree.root.right.right.right = new Node(88);
		tree.inorder();
		System.out.println();
		tree.preorder();
		System.out.println();
		tree.postorder();
		System.out.println();
		tree.printdelete(15);
		tree.inorder();

	}
}