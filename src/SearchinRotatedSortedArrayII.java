import java.util.EmptyStackException;

/**
 * Created by edson on 2018/7/6.
 * 在一个包含重复元素的旋转数组中找一个数
 */
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int start = 0,end = nums.length-1;
        if(end<0)
            return false;
        while (start<=end){
            int meduim = (end-start)/2+start;
            if(nums[meduim]==target) {
               return true;
            }else if(nums[meduim]<nums[end]){
                if(nums[meduim]<target&&nums[end]>=target){
                    start = meduim+1;
                }else{
                   end = meduim-1;
                }
            }else if(nums[meduim]>nums[end]){
                if(nums[meduim]>target&&nums[start]<=target){
                    end = meduim-1;
                }else
                    start = meduim+1;
            }else {
                end--;
            }
        }
        return false;
    }

    public boolean binarySearch(int[] nums,int start,int end,int target){
        if(nums[start]==target||nums[end]==target)
            return true;
        int meduim = (end-start)/2+start;
        while (start<=end){
            if(nums[meduim]==target)
                return true;
            else if(nums[meduim]<target)
                start=meduim+1;
            else if(nums[meduim]>target)
                end=meduim-1;
            meduim = (end-start)/2+start;
        }
        return false;
    }
}
