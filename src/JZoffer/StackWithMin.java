package JZoffer;

import java.util.Stack;

/**
 * Created by woo23 on 2018/6/14.
 * 实现一个栈，并且有一个函数返回这个栈中最小的元素
 */
public class StackWithMin {

    private Stack<Integer> minSatck = new Stack<Integer>();
    private Stack<Integer> stack = new Stack<>();

    public void push(int node) {
        if(minSatck.empty()){
            minSatck.push(node);
        }else if(node<=minSatck.peek())
        {
            minSatck.push(node);
        }
        stack.push(node);
    }

    public void pop() {
        if(stack.peek()<=minSatck.peek()){

            minSatck.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {

        return minSatck.peek();
    }

}
