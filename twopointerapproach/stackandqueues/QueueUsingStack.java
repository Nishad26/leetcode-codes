package stackandqueues;

//232. Implement Queue using Stacks
import java.util.Stack;

public class QueueUsingStack {

    private final Stack<Integer> input;
    private final Stack<Integer> output;

    public QueueUsingStack() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    // if output stack is emoty transfer all elemets from input to output
    public int peek() {
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek()); // returns 1
        System.out.println(queue.pop()); // returns 1
        System.out.println(queue.empty()); // returns false
    }
}
