package linkedlist;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

/*
 * Here always remeber that:-
 * 1. Since your slow is moving lets say slowly one step at a time and your fast
 * is moving fast lets say
 * 2 step at a time, after some time what happens is your fast keeps rotating in
 * the cycle, and then
 * eventually both slow and fast meet each other in the cycle
 * 2. The node at which the both slow and fast meet, ti node tuzaya exactly same
 * distace vaar aste from
 * the node taht starts the cycle , as the
 * node that starts the cycle from the head, means the distace from the meeting
 * node to the node that node thatr
 * starts the cycle is same as the distance between the head node and the node
 * taht starts the cycle
 * 
 */
public class FindingNodeWhereTheCycleStarts {
    public static ListNode hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
    }
}
