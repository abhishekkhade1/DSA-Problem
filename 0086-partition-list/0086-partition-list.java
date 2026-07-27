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

        while(curr!=null){

            ListNode nextNode = curr.next;
            curr.next = null;


            if(curr.val < x){
                smallTail.next = curr;
                smallTail = smallTail.next;
            }else{
                greaterTail.next = curr;
                greaterTail = greaterTail.next;
            }
            curr = nextNode;
        }

     smallTail.next = greaterDummy.next;
     return smallDummy.next;
        
    }
}