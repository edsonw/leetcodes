package JZoffer;

import java.util.LinkedList;

/**
 * Created by woo23 on 2018/6/12.
 * 删除链表当中的节点
 * 要考虑到如果要删除的节点是头结点，或者要删除的节点是尾节点的情况
 */
public class DeleteLinkListElement18 {
    class ListNode{
        int val;
        ListNode nextnode;
        ListNode(int value){
            this.val=value;
        }
    }
    public void solution(ListNode head,ListNode toBeDeleted){
        if(toBeDeleted == null)
            return ;
        if(toBeDeleted.nextnode!=null){
            ListNode next = toBeDeleted.nextnode;
            ListNode nextnext = toBeDeleted.nextnode.nextnode;
            toBeDeleted = next;
            toBeDeleted.nextnode = nextnext;

        }else if(toBeDeleted==head){
            head.nextnode=null;
            return ;
        }else {
            ListNode pre = head;
            while (head.nextnode!=null){
                pre = head;
                head = head.nextnode;
            }
            pre.nextnode=null;
        }
    }
}
