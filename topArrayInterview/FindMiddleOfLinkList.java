package topArrayInterview;

class Node {
    int data;
    Node next;

    Node(int x) {
        this.data = x;
        this.next = null;
    }
}

public class FindMiddleOfLinkList {
    static int getMiddle(Node head) {

        // Initialize the slow and fast pointer to the head
        // of the linked list
        Node slow_ptr = head;
        Node fast_ptr = head;

        while (fast_ptr != null && fast_ptr.next != null) {

            // Move the fast pointer by two nodes
            fast_ptr = fast_ptr.next.next;

            // Move the slow pointer by one node
            slow_ptr = slow_ptr.next;
        }

        // Return the slow pointer which is currently
        // pointing to the middle node of the linked list
        return slow_ptr.data;
    }
}
