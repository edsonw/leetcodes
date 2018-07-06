import javax.swing.text.EditorKit;
import java.net.Inet4Address;

/**
 * Created by woo23 on 2018/6/24.
 * 给定一个排序数组，给一个数，返回这个数在数组当中的范围下标
 */
public class SearchforaRange34 {
    public int[] searchRange(int[] nums, int target) {
        int[] retarray = new int[2];
        retarray[0] = -1;
        retarray[1] = -1;
        if(nums.length==0)
            return retarray;

        int index = binaySearch(nums, 0, nums.length-1, target);

        int start = index;
        int end = index;
        if( index >= 0){
            while (start > 0){
                if (nums[start-1]==target) {
                    start--;
                }else{
                    break;
                }

            }
            while (end<nums.length-1){
                if(nums[end+1]==target){
                    end++;
                }else{
                    break;
                }
            }
            retarray[0] = start;
            retarray[1] = end;
            return retarray;
        } else {
            return retarray;
        }

    }
    public int binaySearch(int[] nums,int start,int end,int target){
        if(end-start>1){
            int medium = (int)Math.floor((end-start)/2)+start;
            if(nums[medium] == target)
                return medium;
            else if (nums[medium] < target){
                return binaySearch(nums, medium, end, target);
            } else if (nums[medium] > target){
                return binaySearch(nums, start, medium, target);
            }
        } else{
            if (nums[start] == target)
                return start;
            else if(nums[end] == target)
                return end;
            else
                return -1;
        }
        return -1;
    }
}
