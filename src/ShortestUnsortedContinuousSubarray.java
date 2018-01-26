/**
 * Created by woo23 on 2018/1/25.
 * 581. Shortest Unsorted Continuous Subarray
 * easy
 */
import java.util.Arrays;
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] old = nums.clone();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == old[i])
                len--;
            else
                break;
        }
        if(len>0){
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == old[i])
                    len--;
                else
                    break;
            }

        }

        return len;
    }

/*

首先假设最左边的一个是最大的，最右边的一个是最小的。
然后我们从第二个到倒数第二个进行比较，如果接下来从左边开始的元素都比刚开始设置的最大的
max = max(max, A[i]) 如果接下来的元素都比上一个最大的元素大，
if (A[i] < max) end = i;然后判断这个元素是否是比最大的元素小，是那么说明需要加入到比较的队列当中，经历过循环之后end之后剩下的就是都比前面的大的元素，
相同的从右边开始比较，如果接下来的元素是比右边最小的元素还小的话说明需要加入到比较的数组当中，如果接下的的数确实比右边最小的元素小，说明不需要加入，这样循环之后
剩下的就是左边的元素比右边最小的元素都小的部分，这样beg-end+1就是最终需要排序的数组的长度了

 */
    public int findUnsortedSubarray2(int[] A) {
        int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
        for (int i=1;i<n;i++) {
            max = Math.max(max, A[i]);
            if (A[i] < max) end = i;

            min = Math.min(min, A[n-1-i]);
            if (A[n-1-i] > min) beg = n-1-i;
        }
        return end - beg + 1;
    }
}
