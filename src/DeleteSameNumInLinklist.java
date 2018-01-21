/**
 * Created by woo23 on 2017/12/5.
 */
 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class DeleteSameNumInLinklist {
    public ListNode deleteDuplication(ListNode pHead){
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = pHead;
        ListNode pre = dummyhead;
        ListNode p = pHead;
        while (p!=null&&p.next!=null){
            if(p.val==p.next.val){
                int val = p.val;
                while (p!=null&&p.val==val)
                    p=p.next;
                pre.next=p;
            }else{
                pre = p;
                p = p.next;
            }
        }
        return dummyhead.next;

    }
}
