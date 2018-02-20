/**
 * Created by edson on 2018/2/17.
 * 给定一个数组，求出改数组当中所有相加为0的三个数的组合，每个数可以在不同的组合当中使用，同一个组合当中只能使用一次。
 * 首先进行排序。
 * 然后进行循环
 */
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
public class Sum_3 {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        for (int i=0;i+2<nums.length;i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }

            int target =-nums[i];
            int j = i+1,k=nums.length-1;
            while (j<k){
                if(nums[j]+nums[k]==target){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while (j<k&&nums[j]==nums[j-1]){
                        j++;
                    }
                    while (j<k&&nums[k]==nums[k+1]){
                        k--;
                    }
                }else if(nums[j]+nums[k]>target){
                    k--;
                }else{
                    j++;
                }

            }
        }
        return res;
    }
}
