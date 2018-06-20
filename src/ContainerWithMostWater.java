/**
 * Created by woo23 on 2018/6/20.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height){
        int lo = 0;
        int hi = height.length-1;
        int max = 0 ;
        while (lo<hi){
            if(height[lo] < height[hi]){
                int temp = height[lo]*(hi-lo);
                if(temp > max){
                    max = temp;
                }
                while (lo < hi && height[lo+1] < height[lo])lo++;
                lo++;
            }else{
                int temp = height[hi]*(hi-lo);
                if(temp > max){
                    max = temp;

                }
                while (lo < hi && height[hi-1] < height[hi])hi--;
                hi--;
            }
        }
        return max;
    }
}
