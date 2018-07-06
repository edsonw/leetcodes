package JZoffer;

import java.util.Stack;

/**
 * Created by woo23 on 2018/6/14.
 * 给定一个栈的压入序列，判断另一个序列是否是弹出序列。
 */
public class ThePushAndPopOrderOfStack31 {
    private Stack<Integer> stack = new Stack<>();
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int i = 0;
        int j = 0;
        stack.push(pushA[j]);
        j++;
        while (i < popA.length - 1 && j < pushA.length - 1){
            if (popA[i] != stack.peek()){
                stack.push(pushA[j]);
                j++;
            } else if(popA[i] == stack.peek()){
                stack.pop();
                i++;
            }
        }
        while(i <= popA.length-1 ){
            if(popA[i] == stack.peek()){
                stack.pop();
            }
            i++;

        }

        return stack.empty();

    }
}
