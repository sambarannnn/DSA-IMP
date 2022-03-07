/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    Node merge(Node a, Node b) {
        Node head = new Node(0);
        Node p = head;
        while(a != null && b != null) {
            if(a.data < b.data) {
                p.bottom = a;
                a = a.bottom;
                p = p.bottom;
            } else {
                p.bottom = b;
                b = b.bottom;
                p = p.bottom;
            }
        }
        if(a != null) {
            p.bottom = a;
        }
        if(b != null) {
            p.bottom = b;
        }
        return head.bottom;
    }
    Node flatten(Node root)
    {
	// Your code here
	    if(root == null || root.next == null) {
	        return root;
	    }
	    root.next = flatten(root.next);
	    
	    root = merge(root, root.next);
	    return root;
    }
}
