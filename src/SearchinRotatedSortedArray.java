import java.security.cert.TrustAnchor;

/**
 * Created by edson on 2018/7/6.
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0,end = nums.length-1;
        if(end<0)
            return -1;
        while (start<=end){
            int mid = (end-start)/2+start;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<nums[end]){
                    if(nums[mid]<target&&nums[end]>=target){
                        start = mid+1;
                    }else
                        end = mid-1;

            }else if(nums[mid]>nums[end]){
                if(nums[mid]>target&&nums[start]>=target){
                    end = mid-1;
                }else
                    start = mid+1;
            }
        }
        return -1;
    }
}
