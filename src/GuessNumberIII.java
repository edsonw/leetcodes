/**
 * Created by woo23 on 2018/3/10.
 * 爱奇艺面试题：一个有序的升序数组从中间切分，分为AB两个部分，将A放到B后面，然后给定一个n，求一个最快的方法从这个数组中查找出来。
 * 思路：先使用二分查找找到且分点，找到切分点之后再对左右两边分别使用二分查找。
 */
public class GuessNumberIII {
    public boolean guess(int[] nums, int index,int n){
        if (nums[index] > n) {
            return true;
        } else {
            return false;
        }
    }
    public int solve(int[] nums,int n){
        int split = findSplit(nums,0, nums.length);
        int left = findNum(nums,0, split, n);
        int right = findNum(nums, split, nums.length, n);
        return Math.max(left,right);
    }

    public int  findNum(int[] nums,int start,int end, int n){
        int medium = start+(end-start)/2;
        if(guess(nums,medium,n)){
            return findNum(nums,start,medium-1,n);
        }else{
            return findNum(nums,medium+1,end,n);
        }
    }
    public int findSplit(int[] nums, int start,int end){
        if (start == end)
            return start;
        int medium = start+(end-start)/2;
        if(nums[medium]>nums[end]){
            return findSplit(nums,medium+1,end);
        }else{
            return findSplit(nums,start,medium-1);
        }
    }
}
