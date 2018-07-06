package JZoffer;

/**
 * Created by woo23 on 2018/6/12.
 * 返回一个链表当中倒数第k个节点
 * 一个指针先走k个，然后另外一个指针同时开始走
 */
public class ReciprocalKNode {
    class ListNode {
        int val;
        ListNode nextnode;
        ListNode(int value){
            this.val=value;
        }
    }
    public ListNode solution1(ListNode head,int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.nextnode;
        }
        while (p1.nextnode != null) {
            p1 = p1.nextnode;
            p2 = p2.nextnode;
        }
        return p2;
    }
}
