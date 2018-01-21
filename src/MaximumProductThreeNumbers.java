/**
 * Created by woo23 on 2017/12/16.
 */
public class MaximumProductThreeNumbers {
    public int maximumProduct(int[] nums) {
        int[] up = new int[1001];
        int[] down = new int[1001];

        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                if(nums[i]>0){
                    up[nums[i]]++;
                }else{
                    down[-nums[i]]++;
                }
            }

        }

        int[] upList = new int[3];
        int[] negList = new int[3];
        int upcount = 0;
        int negcount = 0;
        for(int i=1000;i>0;i--){
            if(up[i] > 0&&upcount<3){
                for(int j=0;j<up[i]&&upcount<3;j++){
                    upList[upcount] = i;
                    upcount++;
                }

            }
            if(down[i] > 0&&negcount<3){
                for(int j=0;j<down[i]&&negcount<3;j++){
                    negList[negcount] = i;
                    negcount++;
                }

            }
        }


        int threeNeg= negList[0]*negList[1]*negList[2];
        int twoNeg = negList[0]*negList[1]*upList[0];
        int oneNeg = negList[0]*upList[0]*upList[1];
        int noNeg = upList[0]*upList[1]*upList[2];

        int zheng = Math.max(noNeg,twoNeg);
        int fu = Math.max(threeNeg,oneNeg);
        if(zheng>0){
            return zheng;
        }else{
            return -fu;
        }


    }
}
