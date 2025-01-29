package stackandqueues;

import java.util.LinkedList;
import java.util.Queue;
//Approach using 2 queues
/*
 * Consider two queues q1 and q2
 * 
 * push operation
 * just push the elemts into q1
 * 
 * pop operation
 * Count elemts in q1
 * Remove n-1 (size of q1-1) elemts from q1 push it into q2
 * last elemts will be the elemt taht you want to pop out (which will ideally be on the top of 
 * stack)
 * make (q2 as q1) and (q1 as q2)
 * push operation should be always done on q1
 *  
 */

//This approach is usining one queue
public class StackUsingQueue {
    private Queue<Integer> queue;

    public StackUsingQueue() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++)
            queue.add(queue.remove());

    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top()); // returns 2
        stack.pop();
        System.out.println(stack.pop()); // returns 1
        System.out.println(stack.empty()); // returns false
    }
}
