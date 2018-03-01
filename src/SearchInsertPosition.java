/**
 * Created by woo23 on 2018/2/2.
 * 35. Search Insert Position easy
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int index=0;
        for(int i=0; i<nums.length; i++) {
            if(target>nums[i])
                index++;
            else if (target == nums[i])
                return index;
        }
        return index;
    }
}
