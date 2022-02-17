class Solution
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x) {
	    
          //add code here.
        Node successor = null;
        while(root != null) {
            if(root.data <= x.data) {
                root = root.right;
            } else if(root.data > x.data) {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}
