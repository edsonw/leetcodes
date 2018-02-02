/**
 * Created by woo23 on 2018/2/1.
 * 724. Find Pivot Index easy
 * 给定一个数组 返回数组中能够将左右两边分为相等的两部分的位置
 * 我的解法：左边和右边的元素依次相加前比较，如果左边的和比右边大那么右边的和就加上下一个元素，然后一直循环到左边和右边的指针相差一个位置时，这种解法当对于都是负数的情况不适用。因为会越来越小。
 *
 * 他人的解法：首先求出数组的总的和，然后左边的元素依次相加，由于返回的那个位置的元素是不算在和当中的，所以我们总和减去指针的下一个元素，如果这个时候的值是左边的和的两倍，那就说明我们找到了那个位置了。
 *
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        /*int i=0,j=nums.length-1;

        int lefttotal =nums[i],righttotal =nums[j];

        while(i+1!=j-1 && i<nums.length-1&&j>0){
            if(lefttotal==righttotal){
                righttotal = righttotal+nums[--j];
            } else if(lefttotal>righttotal) {
                righttotal = righttotal+nums[--j];
            }  else if(lefttotal < righttotal){
                lefttotal = lefttotal+nums[++i];
            }
        }

        if(lefttotal==righttotal&&i+1==j-1 )
            return i+1;
        else
            return -1;*/

        int sum =0, left = 0;
        for (int i = 0;i < nums.length; i++)
            sum += nums[i];
        for (int i = 0;i < nums.length; i++) {
            if (i != 0)left += nums[i- 1];
            if (sum  - nums[i] == 2* left) return i;
        }
        return -1;


    }
}
