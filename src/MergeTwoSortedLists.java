/**
 * Created by edson on 2018/2/17.
 */
public class MergeTwoSortedLists {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode dummyNode = new ListNode(0);
        dummyNode = pre;
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if(l1.val<=l2.val)
        {
            pre.next = l1;
            l1 = l1.next;
        }else{
            pre.next = l2;
            l2 = l2.next;
        }
        pre = pre.next;

        while (l1!=null||l2!=null) {

            if(l1==null&&l2 !=null){
                pre.next = l2;
                l2 = l2.next;
            }else if(l2==null&&l1!=null){
                pre.next = l1;
                l1 = l1.next;
            }else{
                if(l1.val<=l2.val){
                    pre.next = l1;
                    l1 = l1.next;
                }else if(l1.val>l2.val){
                    pre.next = l2;
                    l2 = l2.next;
                }
            }

            pre = pre.next;

        }

        return dummyNode.next;

    }
}
