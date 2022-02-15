class Tree
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // add your code here
        if(root == null) {
            return 1;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int leftVal = (root.left == null) ? 0 : root.left.data;
        int rightVal = (root.right == null) ? 0 : root.right.data;
        
        if(root.data == leftVal+rightVal) {
            if((isSumProperty(root.left) == 1) && (isSumProperty(root.right) == 1))
                return 1;
            else
                return 0;
        } else {
            return 0;
        }
    }
}
