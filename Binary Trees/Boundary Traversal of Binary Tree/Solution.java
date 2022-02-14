//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
	ArrayList <Integer> boundary(Node node) {
	    ArrayList <Integer> leftBoundary = new ArrayList <Integer>();
	    ArrayList <Integer> leafNodes = new ArrayList <Integer>();
	    LinkedList <Integer> rightBoundary = new LinkedList <Integer>();
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    if(node.left != null || node.right != null) {
	        res.add(node.data);
	    }
	    Node p = node.left;
	    if(p != null) {
	        while(p.left != null || p.right != null) {
    	        leftBoundary.add(p.data);
    	        if(p.left != null) {
    	            p = p.left;
    	        } else {
    	            p = p.right;
    	        }
    	    }
	    }
	    p = node;
	    Stack<Node> stack = new Stack<Node>();
	    while(p != null || !stack.isEmpty()) {
	        if(p != null) {
	            if(p.left == null && p.right == null) {
	                leafNodes.add(p.data);
	            }
	            stack.push(p);
	            p = p.left;
	        } else {
	            p = stack.pop();
	            p = p.right;
	        }
	    }
	    p = node.right;
	    if(p != null) {
    	    while(p.left != null || p.right != null) {
    	            rightBoundary.addFirst(p.data);
    	        if(p.right != null) {
    	            p = p.right;
    	        } else {
    	            p = p.left;
    	        }
    	    }
	    }
	    
	    res.addAll(leftBoundary);
	    res.addAll(leafNodes);
	    res.addAll(rightBoundary);
	    return res;
	}
}
