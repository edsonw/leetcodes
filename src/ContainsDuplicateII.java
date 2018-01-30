/**
 *
 * Created by woo23 on 2018/1/26.
 * leetcode 219. Contains Duplicate II easy
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
import java.util.HashMap;
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        boolean flag = false;
        for(int i=0; i<nums.length; i++){
            if (map.containsKey(nums[i])){
                int pre = map.get(nums[i]);
                if(i-pre>k+1)
                    return false;
                else
                    map.put(nums[i], i);
                    flag = true;
            }else {
                map.put(nums[i], i);
            }
        }

        if (flag)
            return true;
        return false;
}
}
