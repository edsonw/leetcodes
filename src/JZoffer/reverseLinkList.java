package JZoffer;

/**
 * Created by woo23 on 2018/6/12.
 * 剑指offer24 反转链表
 */
public class reverseLinkList {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int value){
            this.val=value;
        }
    }
    public ListNode solution1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode p = head.next;
        ListNode next = head.next.next;
//        ListNode dummy = new ListNode(0);
//        dummy.nextnode = head;

        pre.next = null;

        while (next != null) {

            p.next = pre;
            pre = p;
            p = next;
            next = next.next;
        }
        p.next = pre;
        return p;

    }
}
