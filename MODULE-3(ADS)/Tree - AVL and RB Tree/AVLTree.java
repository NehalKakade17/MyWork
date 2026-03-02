class AVLTreeNode{
	int key,height;
	AVLTreeNode left,right;
	AVLTreeNode(int key){
		this.key = key;
		this.height = 1;
	}
}
class AVLTree{
	AVLTreeNode root;
	int height(AVLTreeNode node){
		if(node == null){
			return 0;
		}
		return node.height;
	}
	int getBalance(AVLTreeNode node){
		if(node == null){
			return 0;
		}
		return height(node.left) - height(node.right);
	}
	AVLTreeNode rightRotate(AVLTreeNode n){
		AVLTreeNode x = n.left;
		AVLTreeNode t = x.right;
		x.right = n;
		n.left = t;
		n.height = Math.max(height(n.left),height(n.right))+1;
		x.height = Math.max(height(x.left),height(x.right))+1;
		return x;
	}
	AVLTreeNode leftRotate(AVLTreeNode n){
		AVLTreeNode x = n.right;
		AVLTreeNode t = x.left;
		x.left = n;
		n.right = t;
		n.height = Math.max(height(n.left),height(n.right))+1;
		x.height = Math.max(height(x.left),height(x.right))+1;
		return n;
	}
	AVLTreeNode insert(AVLTreeNode node,int key){
		if(node == null){
			return new AVLTreeNode(key);
		}
		if(key < node.key){
			node.left = insert(node.left,key);
		}
		if(key > node.key){
			node.right = insert(node.right,key);
		}
		else{
			return node;
		}
		int balance = getBalance(node);
		if( balance > 1 && key < node.left.key){
			return rightRotate(node);
		}
		if( balance < -1 && key < node.right.key){
			return leftRotate(node);
		}
		if( balance > 1 && key > node.left.key){
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		if( balance < -1 && key < node.right.key){
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		return node;

	}
	 void inOrder(AVLTreeNode node) {
        	if (node != null) {
            		inOrder(node.left);
            		System.out.print(node.key + " ");
            		inOrder(node.right);
        	}
    	}
	public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);
        System.out.print("In-order traversal: ");
        tree.inOrder(tree.root);
    }

}
