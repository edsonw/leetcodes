import java.util.LinkedList;
import java.util.List;

public class Combinations77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        boolean[] used = new boolean[n+1];
        backTracking(list,new LinkedList<Integer>(),n,k,used,1);
        return list;
    }
    public void backTracking(List<List<Integer>> list,LinkedList<Integer> templist,int k,int n,boolean[] used,int start){
        if(templist.size()==k){
            list.add(new LinkedList<>(templist));
        }else {
            for(int i=1;i<n;i++){
                if(used[i])
                    continue;
                templist.add(i);
                used[i] = true;
                backTracking(list,templist,k,n,used,i+1);
                used[i] = false;
                templist.remove(templist.size()-1);
            }
        }

    }
}
