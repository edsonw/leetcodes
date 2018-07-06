/**
 * Created by woo23 on 2018/3/11.
 * 给定一个链表，判断链表当中是否有环，如果有环的话返回这个环节点，否则返回null
 * 思路：一个走一步 一个走两步 慢的相遇时走环外的A以及环内的B步，快的走了她的两倍 也就是2(A+B) ,假设环内的另一部分是C那么 2(A+B) = A+B+C那么A=C
 * 所以在头结点设置一个指针，相遇点设置一个指针，每次走一步，两者相遇就是环的起始点了。
 *
 */

public class LinkedListCycleII {

    public MergeTwoSortedLists.ListNode detectCycle(MergeTwoSortedLists.ListNode head) {
        if (head == null)
            return null;
        MergeTwoSortedLists.ListNode l1 = head,l2 =head;
        while (l1 != null && l1.next != null) {
            l1 = l1.next.next;
            l2 = l2.next;
            if(l1 == l2) {
                MergeTwoSortedLists.ListNode l3 = head;
                while (l1 != l3){
                    l1 = l1.next;
                    l3 = l3.next;
                }
                return l3;
            }
        }
        return null;

    }
}
