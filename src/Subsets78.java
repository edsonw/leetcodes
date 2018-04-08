
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        backtracking(list,new LinkedList<Integer>(),nums,0);
        return list;
    }
    public void backtracking(List<List<Integer>> list,List<Integer> templist,int[] nums,int start){
        list.add(new LinkedList<>(templist));
        for(int i=start;i<nums.length;i++){
            templist.add(nums[i]);
            backtracking(list,templist,nums,i+1);
            templist.remove(templist.size()-1);
        }

    }
}
