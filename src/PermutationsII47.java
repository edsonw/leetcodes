import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTracking(list,new LinkedList<Integer>(),nums,used);
        return list;
    }

    public void backTracking(List<List<Integer>> list,LinkedList<Integer> tempList,int[] nums,boolean[] used){
        if(tempList.size()==nums.length){
            list.add(new LinkedList<>(tempList));
        }else
        {

            for(int i=0;i<nums.length;i++){
                if(used[i]) continue;
                if(i>0&&nums[i-1]==nums[i]&&!used[i-1])
                    continue;
                tempList.add(nums[i]);
                used[i] = true;
                backTracking(list,tempList,nums,used);
                used[i] = false;
                tempList.remove(tempList.size()-1);



            }
        }

    }
}
