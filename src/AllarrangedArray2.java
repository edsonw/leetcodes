/**
 * Created by woo23 on 2017/12/15.
 * 数组的全排列（包含重复元素）
 * 思路：计算数组的全排列,因为使用的分治算法，将数组的前部分和后部分分开，
 *
 */
public class AllarrangedArray2 {
    public void solution(int[] nums) {
        allRangedArray(nums, 0, nums.length);
    }

    private void  allRangedArray(int[] nums, int start, int end) {
        if (start == end){
            for (int i = 0;i < end; i++){
                System.out.print(nums[i]);
            }
            System.out.println();
        } else {
            for (int i = start; i < end; i++){
                if(isSwap(nums, i, end)){
                    swap(nums, start, i);
                    allRangedArray(nums, start + 1, end);
                    swap(nums, start, i);
                }

            }

        }
    }
    private boolean isSwap(int[] nums, int index,int len){
        for (int i = index + 1; i < len; ++i){
            if (nums[i] == nums[index])
                return false;
        }
        return true;
    }

    private void swap(int[] nums , int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}
