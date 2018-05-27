import java.util.ArrayList;
import java.util.List;

public class Triangle120
{
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        List<Integer> retlist = new ArrayList<Integer>();
        for(int i=0;i<size;i++){
            retlist=helper(i,triangle,retlist);
        }
        int minnum = Integer.MAX_VALUE;
        for(int num:retlist){
            minnum = Math.min(num,minnum);
        }
        return minnum;
    }
    public static List<Integer> helper (int level,List<List<Integer>> triangle,List<Integer> minlevel){
        if(level==0){
            return triangle.get(0);
        }
        List<Integer> retlist = new ArrayList<Integer>();
        int size = triangle.get(level).size();
        for(int i=0;i<size;i++){
            if(i==0){
                retlist.add(triangle.get(level).get(i)+minlevel.get(i));
            }else if(i==size-1){
                retlist.add(triangle.get(level).get(i)+triangle.get(level-1).get(i-1));
            }else{
                retlist.add(Math.min(triangle.get(level).get(i)+minlevel.get(i),triangle.get(level).get(i)+minlevel.get(i-1)));
            }
        }
        return retlist;
    }
}
