//User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root){
      // Your code here
        ArrayList<Integer> view = new ArrayList<Integer>();
    //   Queue<Node> queue = new LinkedList<Node>();
    //   if(root == null)
    //   return view;
    //   queue.add(root);
    //   while(!queue.isEmpty()){
    //       int size = queue.size();
    //       for(int i = 0; i < size; i++) {
    //           Node curr = queue.remove();
    //           if(i == 0) {
    //               view.add(curr.data);
    //           }
    //           if(curr.left != null) {
    //               queue.add(curr.left);
    //           }
    //           if(curr.right != null) {
    //               queue.add(curr.right);
    //           }
    //       }
        
    //  }
        int level = 0;
        preorderTraversal(root, level, view);
        return view;
    }
    
    private static void preorderTraversal(Node root, int level, List<Integer> view) {
        if(root == null) {
            return;
        }
        if(level == view.size()) {
            view.add(root.data);
        }
        preorderTraversal(root.left, level+1, view);
        preorderTraversal(root.right, level+1, view);
    }
}
