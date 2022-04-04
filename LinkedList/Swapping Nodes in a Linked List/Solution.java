/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        // example : k = 2
        //find first from left side
        //k + no of remaining nodes = no of remaining nodes + k
        // iterating from k+1 to null makes us travel no of remaining nodes
        //simultaneously iterate from head till above condition terminates
        // second pointer is at second required node
        
        //     <----------->
        // 1 2 3 4 5 6 7 8 9
        //   f <----------->
        //     1 2 3 4 5 6 7 8 9
        //                 s
        ListNode first = head;
        for(int i = 0; i < k-1; i++) {
            first = first.next;
        }
        ListNode second = head;
        ListNode p = first.next;
        while(p != null) {
            p = p.next;
            second = second.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }
}
