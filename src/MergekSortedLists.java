
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by woo23 on 2018/6/22.
 */
public class MergekSortedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode head = new ListNode(0);
        dummy.next = head;
        SortedMap<Integer,Integer> map = new TreeMap<Integer,Integer>();

        for(int i=0;i<lists.length;i++){
            while (lists[i]!=null){
                if(map.containsKey(lists[i].val)){
                    int counts = map.get(lists[i].val);
                    counts++;
                    map.put(lists[i].val,counts);
                }else{
                    map.put(lists[i].val,1);
                }
                lists[i] = lists[i].next;
            }
        }
        Iterator<Integer> iter = map.keySet().iterator();

        while (iter.hasNext()){
            int key = iter.next();
            int value = map.get(key);
            for (int i = 0;i < value; i++){
                ListNode temp = new ListNode(key);
                head.next = temp;
                head = head.next;
            }
        }
        return dummy.next.next;

    }
}
