/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode hA = headA;
        ListNode hB = headB;
        
        while(hA != hB) {
            if(hA == null) {
                hA = headB;
            } else {
                hA = hA.next;
            }
            if(hB == null) {
                hB = headA;
            } else {
                hB = hB.next;
            }
        }
        return hA;
    }
}
