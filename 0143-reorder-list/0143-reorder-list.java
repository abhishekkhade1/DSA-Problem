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
    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = reverse(slow.next);
        slow.next = null;

        ListNode first = head;
        ListNode second = head2;

        while (second != null) {
            ListNode next1 = first.next;
            ListNode next2 = second.next;

            first.next = second;
            second.next = next1;

            first = next1;
            second = next2;
        }

        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        
    }
    private ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // private ListNode mergeLL(ListNode l1 , ListNode l2){

    //     ListNode dummy = new ListNode(-1);
    //     ListNode tail = dummy;
    //     ListNode p1 = l1;
    //     ListNode p2 = l2;

    //     while(p1!=null && p2!=null){
            
    //         tail.next = p1;
    //         tail = tail.next;

    //         tail.next = p2;
    //         tail = tail.next;

            
    //         if(p1.next!=null) p1 = p1.next;
    //         if(p2.next!=null) p2 = p2.next;
    //     }
        
    //     while(p1!=null){
    //         tail.next = p1;
    //     }
    //     while(p2!=null){
    //         tail.next = p2;
    //     }
    //     return dummy.next;
    // }
}