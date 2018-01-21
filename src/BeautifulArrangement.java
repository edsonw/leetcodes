import java.awt.*;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by woo23 on 2017/12/29.
 * leetcode 526 判断一个数组，数组中的元素都是小于N且不重复的元素，如果一种组合当中第i个位置的元素可以对i整除，或者i可以整除第i个位置的元素，那么这个数组就叫做美丽的安排，求xiaoyun有多少种美丽的安排。
 *
 * 初步解法：求解出所有的排列组合，然后判断每个排列组合是不是。(超时）
 *
 */
public class BeautifulArrangement {
    private int count = 0;
    public int countArrangement(int N){
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = i + 1;
        }

        allArrangement(nums, 0, nums.length);
        return count;
    }
    private void   allArrangement(int[] nums,int start,int end){
        boolean flag = true;
        if (start == end - 1) {
            for (int i = 1; i <= nums.length; i++){
                if (nums[i - 1] % i != 0 && i % nums[i - 1] != 0){               flag = false;
                    break;
                }
            }
            if (flag)
            count++;
        }

        for (int i = start; i < end; i++){
            swap(nums, start, i);
            allArrangement(nums, start + 1 , end);
            swap(nums, start, i);
        }



    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    //解法2 回溯算法
    public int countArrangement2(int N){
        if(N==0) return 0;
        helper(N,1,new int[N+1]);
        return count;

    }
    private void helper(int N, int pos, int[] used){
        if (pos > N){
            count++;
            return;
        }
        for (int i = 1; i <= N; i++){
            if (used[i] == 0 && (i % pos == 0 || pos % i == 0)){
                used[i] = 1;
                helper(N, pos +  1, used);
                used[i] = 0;
            }
        }
    }


    /*
    * leetcode 1
    * 给定一个数组，从数组中找出两个数的和为target
    * 通过一个hashmap来存放值，和位置，在存放一个新的值时检查hashmap当中是否有刚好为剩余值的数已经存放了。
    * */
    public int[] twosum(int[] nums,int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ret = new int[2];
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                ret[0] = map.get(target - nums[i]);
                ret[1] = i;
                return ret;
            }
            map.put(nums[i],i);
        }
        return ret;
    }
}
