/**
 * Created by woo23 on 2017/12/9.
 * leetcode 155 easy Min Stack
 *Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 Example:
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.
 思路：用一个辅助栈来存放出现过的最小值，如果有多个最小值那么要存入这多个值吗
 注意点：故这里存入的值如果小于等于当前的最小值都要存进去
 */

import java.util.Stack;
public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        if(minStack.empty()){
            minStack.push(x);
        }else{
            int min = minStack.peek();
            if (x<min)
                minStack.push(x);
        }

        stack.push(x);

    }

    public void pop() {
        int temp = stack.peek();
        if (temp==minStack.peek())
            minStack.pop();
        stack.pop();
    }

    public int top() {
        if(!stack.empty()){
            return stack.peek();
        }else{
            return 0;
        }


    }

    public int getMin() {
       if(!minStack.empty()){
           return minStack.peek();
       }else{
           return 0;
       }
    }
}
