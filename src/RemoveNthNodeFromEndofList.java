/**
 * Created by woo23 on 2018/6/21.
 * 移除导数第n个节点，这个问题一个技巧就是用一个dummynode，dummy node可以用来解决移除头节点的问题
 * 因为当移除头节点的时候不好存放状态
 */
public class RemoveNthNodeFromEndofList {


      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode slow= dummy,fast = dummy;
        dummy.next = head;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
    }
