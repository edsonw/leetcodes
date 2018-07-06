import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetII90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        backTracking(list,new LinkedList<Integer>(),nums,0);
        return list;
    }
    public void backTracking(List<List<Integer>> list,List<Integer> templist, int[] nums,int start){
        list.add(new LinkedList<>(templist));
        for (int i = start;i<nums.length;i++){
            if(i>start&&nums[i-1]==nums[i])
                continue;
            templist.add(nums[i]);
            backTracking(list,templist,nums,i+1);
            templist.remove(templist.size()-1);
        }
    }
}
