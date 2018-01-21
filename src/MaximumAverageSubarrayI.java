/**
 * Created by woo23 on 2017/12/16.
 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {

        int max = 0;
        int tempMax = 0;

        int end = k;
        int count = k;
        int begain =0;
        while(k>0){
            k--;
            tempMax = tempMax+nums[k];

        }
        max = tempMax;
        for(int i =end;i<nums.length;){
            tempMax =tempMax-nums[begain]+nums[i];
            max = Math.max(tempMax,max);
            begain++;
            i++;

        }

        return (double)max/count;
    }

}
