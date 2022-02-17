/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int K)
    {
        //NO EXTRA SPACE AT ALL
        //Your code here
        int totalNodes = 0;
        Node p = root;
        while(p != null) {
            if(p.left != null) {
                Node q = p.left;
                while(q.right != p && q.right != null) {
                    q = q.right;
                }
                if(q.right == null) {
                    q.right = p;
                    p = p.left;
                }else if(q.right == p) {
                    totalNodes++;
                    q.right = null;
                    p = p.right;
                }
            } else {
                totalNodes++;
                p = p.right;
            }
        }
        
        int reqSmallest = totalNodes - K + 1;
        int visitedNodes = 0;
        p = root;
        while(p != null) {
            if(p.left != null) {
                Node q = p.left;
                while(q.right != p && q.right != null) {
                    q = q.right;
                }
                if(q.right == null) {
                    q.right = p;
                    p = p.left;
                }else if(q.right == p) {
                    visitedNodes++;
                    q.right = null;
                    if(visitedNodes == reqSmallest) {
                        return p.data;
                    }
                    p = p.right;
                }
            } else {
                visitedNodes++;
                if(visitedNodes == reqSmallest) {
                    return p.data;
                }
                p = p.right;
            }
            
        }
        return -1;
    }
}
