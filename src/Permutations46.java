import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTracking(list,new LinkedList<Integer>(),nums,used);
        return list;
    }
    public void backTracking(List<List<Integer>> list,LinkedList<Integer> templist ,int[] nums,boolean[] used){
        if(templist.size()==nums.length){
            list.add(new LinkedList<>(templist));
        }else{
            for (int i=0;i<nums.length;i++){
                if(used[i])
                    continue;
                used[i] = true;
                templist.add(nums[i]);
                backTracking(list,templist,nums,used);
                used[i] = false;
                templist.remove(templist.size()-1);
            }
        }

    }
}
