/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/
import java.util.*;
class NodeVisit{
    int visit;
    BinaryTreeNode node;
    NodeVisit(BinaryTreeNode node) {
        this.node = node;
        this.visit = 1;
    }
    NodeVisit(BinaryTreeNode node, int visit) {
        this.node = node;
        this.visit = visit;
    }
}
public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here.
        List preorder = new ArrayList<>();
        List inorder = new ArrayList<>();
        List postorder = new ArrayList<>();
        //NOTE THAT PREORDER : FIRST VISIT
        //INORDER : SECOND VISIT
        //POSTORDER : THIRD VISIT
        BinaryTreeNode p = root;
        Stack<NodeVisit> stack = new Stack<>();
        while(p != null || !stack.isEmpty()) {
            if(p != null) {
                preorder.add(p.data);
                stack.push(new NodeVisit(p, 1));
                p = p.left;
            } else {
                
                int visit = stack.peek().visit;
                p = stack.pop().node;
                if(visit == 1) {
                    inorder.add(p.data);
                    stack.push(new NodeVisit(p, 2));
                    p = p.right;
                } else if(visit == 2){//node visited twice already
                    postorder.add(p.data);
                    p = null;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(inorder);
        res.add(preorder);
        res.add(postorder);
        return res;
    }
}
