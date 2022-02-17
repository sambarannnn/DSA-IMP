public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.
        //find inorder predecessor including itself
        TreeNode predecessor = null;
        while(root != null) {
            if(root.data > X) {
                root = root.left;
            } else if(root.data <= X) {
                predecessor = root;
                root = root.right;
            }
        }
        return (int)predecessor.data;
    }
}
