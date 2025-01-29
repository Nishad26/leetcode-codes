package recursionandbacktracking;

import java.util.Stack;

public class DeleteMiddleElemtofStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        int mid = Double.valueOf(Math.floor((stack.size() + 1) / 2)).intValue() - 1;
        deleteMiddleElementFromStack(stack, mid);
        System.out.println(stack);
    }

    public static void deleteMiddleElementFromStack(Stack<Integer> stack, int mid) {
        if (stack.size() - 1 == mid) {
            stack.pop();
            return;
        }
        int value = stack.pop();
        deleteMiddleElementFromStack(stack, mid);
        stack.push(value);
    }
}
