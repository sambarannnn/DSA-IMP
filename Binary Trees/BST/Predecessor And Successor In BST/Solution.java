import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		// Write your code here.
        ArrayList<Integer> res = new ArrayList<Integer>();
        BinaryTreeNode predecessor = null;
        BinaryTreeNode successor = null;
        while(root != null) {
            if(root.data < key) {
                predecessor = root;
                root = root.right;
            } else if(root.data > key) {
                successor = root;
                root = root.left;
            } else {//when both are equal
                BinaryTreeNode left = root.left;
                if(root.left != null) {
                    BinaryTreeNode pre = root.left;
                    while(pre.right != null) 
                        pre = pre.right; 
                    predecessor = pre;
                }
                if(root.right != null) {
                    BinaryTreeNode suc = root.right;
                    while(suc.left != null) 
                        suc = suc.left;
                    successor = suc;
                }
                break;
            }
        }
        if(predecessor == null) {
            res.add(-1);
        } else {
            res.add((int)predecessor.data);
        }
        if(successor == null) {
            res.add(-1);
        } else {
            res.add((int)successor.data);
        }
        return res;
	}
}
