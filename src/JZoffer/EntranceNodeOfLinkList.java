package JZoffer;

/**
 * Created by woo23 on 2018/6/12.
 * 返回一个有环的链表当中的环的入口节点
 */
public class EntranceNodeOfLinkList {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int value){
            this.val=value;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        while (fast!=null || slow!=null) {
            if(slow != fast){
                slow = slow.next;
                fast = fast.next.next;
            } else {
                break;
            }
        }
        if(slow != null){
            ListNode p = pHead;
            while (p != slow){
                p = p.next;
                slow = slow.next;
            }
            return p;
        } else {
            return null;
        }

    }
}
