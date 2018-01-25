package LinkedList;

import java.awt.font.TextHitInfo;

/**
 * Created by woo23 on 2017/12/3.
 */



public class ReverseLinkList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        ListNode pre = null;
        ListNode temp = head;
        while (temp!=null){
            ListNode next = temp.next;
            temp.next=pre;
            pre=temp;
            temp = next;
        }
        return pre;

    }

    /**
     * 将链表的m-n位置反转
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {


        if(head==null)
            return null;
        if (head.next == null)
            return head;
//        设置一个trick节点来指向头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
//        设置一个pre节点用于记录需要反转的子链表的前一个位置
        ListNode pre =dummy;
//        循环一直到需要进行反转链表的位置
        for(int i =0;i<m-1;i++){
            pre = pre.next;
        }
//        设置start then两个位置为进行反转的位置
        ListNode start = pre.next;
        ListNode then = start.next;
//        将需要反转的位置的头一个元素的next指向空。
        start.next = null;
//        根据位置将需要反转的链表进行反转
        for(int i=0;i<n-m;i++){
            ListNode next =then.next;
            then.next = start;
            start = then;
            then = next;
        }
//        将头链表指向反转后的链表的头结点
        pre.next = start;
//        遍历到反转后的子链表尾部
        while (pre.next!=null)
            pre = pre.next;
//       将反转后的子链表尾指向剩余链表的头部
        pre.next = then;
//        返回头链表结点
        return dummy.next;


    }

    /**
     * 格式：

     输入行输入一个整数 n 和一个数字 k，最后输出数字 k 在 0 到 n 中出现的次数。
     样例输入
     n = 12
     k = 1
     样例输出
     5
     * @param n
     * @param k
     * @return
     */
    public int countNum(int n,int k){

        return 0;
    }

}
