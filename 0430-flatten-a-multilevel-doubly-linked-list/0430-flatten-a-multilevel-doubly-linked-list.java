/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {

        if (head == null) {
            return head;
        }

        Node curr = head;

        while (curr != null) {

            if (curr.child != null) {

                Node next = curr.next;

                // Flatten child list
                Node childHead = flatten(curr.child);

                // Connect curr -> child
                curr.next = childHead;
                childHead.prev = curr;

                // Child is no longer needed
                curr.child = null;

                // Find end of child list
                Node tail = childHead;

                while (tail.next != null) {
                    tail = tail.next;
                }

                // Connect child tail -> original next
                if (next != null) {
                    tail.next = next;
                    next.prev = tail;
                }
            }

            curr = curr.next;
        }

        return head;
    }
}