    Following is the Binary Tree node structure

    class BinaryTreeNode < Integer > {
        int data;
        BinaryTreeNode < Integer > left;
        BinaryTreeNode < Integer > right;

    public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

*************************************************************/

public class Solution {
    public static void changeTree(BinaryTreeNode < Integer > root) {
        // Write your code here.
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            return;
        }
        int leftVal = (root.left == null) ? 0 : root.left.data;
        int rightVal = (root.right == null) ? 0 : root.right.data;
        
        if(leftVal + rightVal < root.data) {
            if(root.left != null) {
                root.left.data = (root.right == null) ? root.data : root.data-root.right.data;
            } else if(root.right != null) {
                root.right.data = (root.left == null) ? root.data : root.data - root.left.data;
            }
        }
        changeTree(root.left);
        changeTree(root.right);
        
        leftVal = (root.left == null) ? 0 : root.left.data;
        rightVal = (root.right == null) ? 0 : root.right.data;
        if(leftVal != 0 || rightVal != 0) {
            root.data = leftVal + rightVal;
        }
    }
}
