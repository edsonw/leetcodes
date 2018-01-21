package DP;

import sun.security.util.Length;

/**
 * Created by woo23 on 2017/12/9.
 * 动态规划青蛙跳问题
 * 每次可以跳1步或者2步
 * 条件：每次青蛙可以跳1次或者2次，第一步可以有两种情况，第二步也有两种情况，第三步
 * 思路：动态规划需要找到状态转移方程，状态转移方程就是如何重一个复杂的状态转移到一个简单的状态，这样才能将问题简化。
 最优子结构：就是f(9)+f(8) 将一个大的问题分解为一个小的问题
 边界：就是状态转移方程停止的条件。
 */
public class FrogJump {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }
    public static int jump(int length){
        if (length<1)return 0;
        if(length==1)return 1;
        if (length == 2) return 2;

        return jump(length-1)+jump(length-2);
    }

    public static int jump2(ListNode length){
//        if (length<1)return 0;
//        if(length==1)return 1;
//        if (length == 2) return 2;
//        int count=0;
//        int f1 = 1;
//        int f2=2;
//        for(int i=3;i<=length;i++){
//            count = f2+f1;
//            f1=f2;
//            f2=count;
//        }
        length.val = length.val+1;
        System.out.print(length.val);
        return 0;
//        return count;
    }
}

