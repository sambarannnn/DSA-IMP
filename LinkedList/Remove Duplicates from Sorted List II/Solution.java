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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null) {
            if(curr.next != null && curr.next.val == curr.val) {
                ListNode toBeDeleted = curr;
                
                while(curr != null && curr.val == toBeDeleted.val) {
                    curr = curr.next;
                }
                
                if(toBeDeleted == head) {
                    head = curr;
                } else {
                    prev.next = curr;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
