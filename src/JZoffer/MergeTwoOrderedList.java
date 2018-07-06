package JZoffer;

/**
 * Created by woo23 on 2018/6/12.
 *合并两个有序的链表
 */
public class MergeTwoOrderedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int value) {
            this.val=value;
        }
    }
    public ListNode Merge(ListNode l1,ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val > l2.val) {
            dummy.next = l2;
            head = l2;
            l2 = l2.next;
        } else {
            dummy.next = l1;
            head = l1;
            l1 = l1.next;
        }

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 == null)
            head.next = l2;
        if (l2 == null)
            head.next = l1;
        return dummy.next;
    }
}
