package LinkedList;

import sun.java2d.opengl.WGLGraphicsConfig;

import java.lang.reflect.Member;

/**
 * Created by woo23 on 2017/12/10.
 * leetcode medium
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public void reorderList(ListNode head) {
        if (head==null||head.next==null)return;

//        通过一个快节点一个慢节点将链表分为前后两个部分
        ListNode pre =null,fast=head,slow = head,l1=head;

        while (fast!=null&&fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
//        从中间节点划分
        pre.next = null;
//        将后半部分反转
        ListNode l2 = reverse(slow);

//      合并前后两部分链表
        merge(l1,l2);


    }

    /**
     * 将两个链表合并，l1\l2间隔开，
     * @param l1
     * @param l2
     */
    public void merge(ListNode l1,ListNode l2){
        while (l1!=null){
            ListNode n1 = l1.next,n2=l2.next;

            l1.next = l2;
            if(n1==null)
                break;
            l2.next = n1;
            l1 = n1;
            l2 =n2;

        }
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        while (head!=null){
            ListNode temp =head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }


}
