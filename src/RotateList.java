/**
 * Created by woo23 on 2018/7/19.
 * 旋转一个list
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode start = head;
        int count = 0;
        if(head==null||head.next==null)
            return head;
        while(start.next!=null){
            count++;
            start = start.next;
        }
        count++;
        start.next = head;
        int step = count-(k%count);
        while(step>0){
            start = start.next;
            step--;
        }
        ListNode newHead = start.next;
        start.next = null;
        return newHead;

    }
}
