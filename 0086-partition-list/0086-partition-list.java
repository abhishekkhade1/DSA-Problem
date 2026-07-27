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
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(-1);
        ListNode smallTail = smallDummy;

        ListNode greaterDummy = new ListNode(-1);
        ListNode greaterTail = greaterDummy;

        if(head == null) return head;

        ListNode curr = head;

        while (head != null) {

            if (head.val < x) {
                smallTail.next = head;
                smallTail = smallTail.next;
            } else {
                greaterTail.next = head;
                greaterTail = greaterTail.next;
            }
            head = head.next;
        }
     greaterTail.next = null;
     smallTail.next = greaterDummy.next;
     return smallDummy.next;
        
    }
}