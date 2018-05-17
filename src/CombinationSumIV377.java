public class CombinationSumIV377 {
    private static int count =0;
    public int combinationSum4(int[] nums, int target) {
//        int count =0;
        backTracking(nums,target,0,count);
        return count;
    }
    public void backTracking(int[] nums,int target,int temp,int count){
        if(temp==target){
            count++;
        }else if(temp<target){
            for(int i=0;i<nums.length;i++){
                temp = temp+nums[i];
                backTracking(nums,target,temp,count);
                temp = temp-nums[i];
            }
        }
    }
}
