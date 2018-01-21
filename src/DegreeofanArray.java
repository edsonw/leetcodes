import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by woo23 on 2017/12/14.
 *
 */
public class DegreeofanArray {
    public int findShortestSubArray(int[] nums) {

        ArrayList<Integer> mostNums =findMostApperance(nums);
        int smallLeast = nums.length;
        for(int i= 0;i < mostNums.size(); i++){
            int small = helper(nums, mostNums.get(i));
            smallLeast = Math.min(small, smallLeast);
        }
        nums[0] = 10;
        return smallLeast;
    }

    public ArrayList<Integer> findMostApperance(int[] nums){
        int[] countArray = new int[50000];
        ArrayList<Integer> mostNums = new ArrayList<>();
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            countArray[nums[i]]++;
        }
        for (int i = 0; i < 50000; i++) {
            if (countArray[i] > maxCount)
                maxCount = countArray[i];
        }
        for (int i = 0; i < 50000; i++) {
            if (countArray[i] == maxCount)
                mostNums.add(i);
        }
        return mostNums;
    }

    public int helper(int[] nums,int degree) {
        int i = 0, j = nums.length- 1;
        while (nums[i] != degree)
            i++;
        while (nums[j] != degree)
            j--;
        return j - i+1;
    }
}
