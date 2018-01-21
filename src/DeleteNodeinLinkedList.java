/**
 * Created by woo23 on 2017/12/7.
 */
import org.w3c.dom.ls.LSInput;

import java.util.Stack;
public class DeleteNodeinLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 给定一个节点，链表中的该节点
     * leetcode 237. Delete Node in a Linked List
     * @param node
     */
    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }

    /**
     * leetcode 445. Add Two Numbers II
     * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

     You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     Follow up:
     What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

     Example:

     Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 8 -> 0 -> 7
     * @param l1
     * @param l2
     * @return
     * 错误思路：由于本题说明了不能将链表反转，所以我首先想到的是在原有链表的基础上生成一个新的链表，用于存储进位数的结果。首先是判断两个链表的长度。先遍历长的那个然后遍历到可以相加的位置将加完的结果除10后存到长的链表当然，然后重新遍历长的链表，将对应的位置上加上进位数。但是这样做有一个坏处就是当遇到 9->9 + 1这种情况需要判断是不是要新加一个节点，而且需要进行三次判断，判断l1 l2的关系。
    正确思路：
    将两个链表存入栈当中，这样读取的就是最后一个元素了，然后依次相加两个栈当中的元素。通过中间变量记录相加后的进位数，然后通过反向建立链表的方式，就是每次新建的节点都是作为头结点。

     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       /* int l1Length = linkLength(l1);
        int l2Length = linkLength(l2);
        ListNode dummy = new ListNode(-1);
        ListNode tempHead = new ListNode(-1);
        ListNode temp = new ListNode(-1);
        tempHead = temp;
        if (l1Length > l2Length){
            dummy.next = l1;
            for(int i=0;i<l1Length-l2Length;i++){
                l1=l1.next;
            }
            while (l1!=null){
                temp.next = new ListNode((l1.val+l2.val)/10);
                temp = temp.next;
                l1.val = (l1.val+l2.val)%10;
                l1 = l1.next;
                l2 = l2.next;
            }

            ListNode templ1 = dummy.next;
            for(int i=0;i<l1Length-l2Length-1;i++){
                templ1=templ1.next;
            }
            while (tempHead.next!=null){
                templ1.val = templ1.val+tempHead.next.val;
                tempHead = tempHead.next;
                templ1 = templ1.next;
            }

        }else if (l1Length <l2Length){
            dummy.next = l2;
            for(int i=0;i<l2Length-l1Length;i++){
                l2=l2.next;
            }
            while (l2!=null){
                temp.next = new ListNode((l1.val+l2.val)/10);
                temp = temp.next;
                l2.val = (l1.val+l2.val)%10;
                l1 = l1.next;
                l2 = l2.next;
            }

            ListNode templ2 = dummy.next;
            for(int i=0;i<l2Length-l1Length-1;i++){
                templ2=templ2.next;
            }
            while (tempHead.next!=null){
                templ2.val = templ2.val+tempHead.next.val;
                tempHead = tempHead.next;
                templ2 = templ2.next;
            }


        }else{
            dummy.next = l1;
            while (l1!=null){
                temp.next = new ListNode((l1.val+l2.val)/10);
                temp = temp.next;
                l1.val = (l1.val+l2.val)%10;
                l1 = l1.next;
                l2 = l2.next;
            }

            ListNode templ2 = dummy.next;
            tempHead = tempHead.next;
            while (tempHead.next!=null){
                templ2.val = templ2.val+tempHead.next.val;
                tempHead = tempHead.next;
                templ2 = templ2.next;
            }
        }
        return dummy.next;*/
       Stack<Integer> s1 = new Stack<Integer>();
       Stack<Integer> s2 = new Stack<Integer>();
       while (l1!=null){
           s1.push(l1.val);
           l1 = l1.next;
       }
       while (l2!=null){
           s2.push(l2.val);
           l2 = l2.next;
       }
       int sum = 0;
       ListNode list = new ListNode(0);
       while (!s1.empty()||!s2.empty()){
           if(!s1.empty()) sum +=s1.pop();
           if(!s2.empty()) sum +=s2.pop();
           list.val =sum%10;
           ListNode head = new ListNode(sum/10);
           head.next = list;
           list = head;
           sum /=10;

       }
       return list.val==0? list.next : list;



    }

    public int linkLength(ListNode node){
        int count =0;
        while (node!=null){
            count++;
            node = node.next;

        }
        return count;

    }

}
