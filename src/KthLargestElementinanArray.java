import java.util.PriorityQueue;

/**
 * Created by woo23 on 2018/6/27.
 */
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num:nums)
            queue.add(num);
        for(int i =0;i<nums.length-k;i++){
            queue.poll();
        }
        return queue.peek();
    }
}
