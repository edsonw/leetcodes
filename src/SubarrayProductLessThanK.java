/**
 * Created by woo23 on 2017/12/24.
 * leetcode713 打印一个数组的排列组合的乘积小于K的子序列
 * 子序列可能存在乘积相同的情况，乘积相同可能是元素相同也可能元素不同
 */
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class SubarrayProductLessThanK {


    public int numSubarrayProductLessThanK(int[] nums, int k) {
        Stack<Integer> stack = new Stack<Integer>();
        int interval = 1;
        int count = 0;
        while (interval != nums.length){
            for (int i = 0; i + interval < nums.length; i++){
                if (isValidate(nums, i, i + interval, k)){
                    count++;
                }
            }
            interval++;
        }
        return count;

    }
    public boolean isValidate(int[] nums,int start, int end,int k){
        int mult = 1;
        for (int i = start; i < end; i++){
            mult = mult * nums[i];
        }

        if (mult < k) {
            return true;
        }
        else return false;

    }

    /**
     *
     * @param nums
     * @param k
     * @return
     * 算法解析，通过设置一个最大窗口，如果窗口右边加进来一个新的数字之和就开始移除左边的数字，最大窗口的积小于k。
     * 举例说明：10 5 2 6
     * +10 ，cnt=1 10 2 cnt=3 ,每加进一个新的元素，就可以后前面的连续数组进行组合，每加进一个可就可以构造当前长度个的组合。
     *
     * 为什么这种做法不会出现
     */

    public int  realSolution(int[] nums,int k){
        if (k == 0) return 0;
        int cnt = 0;
        int pro = 1;
        for (int i = 0, j = 0; j < nums.length; j++){
                       pro = pro * nums[j];
            while (i <= j && pro >= k) {
                pro =  pro / nums[i++];
            }
            cnt = cnt + j - i + 1;

        }
        return cnt;

    }

}
