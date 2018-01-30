/**
 * Created by woo23 on 2018/1/29.
 * leetcode 220. Contains Duplicate III medium
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 * my：两重循环，第一重遍历数组中所有的数，第二重根据i的值遍历前k个元素和后k个元素，使用j来表示，如果i==j跳过，然后比较两者之间的大小关系，是否在t之间，如果符合要求则返回true。遍历完之后还没有就是false 这样的做法会超时
 *
 * solution：用一个map存放k个元素，如果进来了一个元素就判断这k个元素当中有没有差值为t的，这里不用循环遍历，使用桶的方法，例如（3，4,5） t为3 那么这三个元素都可以放到一个桶里，所以放到一个桶里的元素就一定是复合要求的，,如果这个值是4，那么，另外的值在（6,7,8）(0,1,2)这两个桶中实际上也是符合要求的，所以映射的桶和下一个桶及上一个桶都是符合要求的，如果桶的个数超过了k个表示长度一定是不符合要求的，所以删除最开始的那个桶。
 */

import java.util.Map;
import java.util.HashMap;
import java.math.BigInteger;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int begain = 0;
            int end = 0;
            if(i+k>=nums.length)
                end = nums.length-1;
            else
                end = i + k;
            if(i-k<0)
                begain = 0;
            else
                begain = i-k;
            for(int j = begain; j<=end; j++){
                    if (i == j)
                        continue;
                    if (Math.abs((long)((long)nums[j] - (long)nums[i]))<= t){
                        return true;
                    }
                }

            }
        return false;
        }


//        if (k < 1 || t < 0) return false;
//        Map<Long, Long> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
//            long bucket = remappedNum / ((long) t + 1);
//            if (map.containsKey(bucket)
//                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
//                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
//                return true;
//            if (map.entrySet().size() >= k) {
//                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
//                map.remove(lastBucket);
//            }
//            map.put(bucket, remappedNum);
//        }
//        return false;



}
