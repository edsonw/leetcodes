import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by edson on 2018/4/9.
 */
public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        int n = nums.length/2;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num:nums){
            if(map.containsKey(num)){
                int val = map.get(num);
                val++;
                map.put(num,val);
            }else {
                map.put(num, 1);
            }
        }
        for (Integer key:map.keySet()) {
            if(map.get(key)>n){
                return key;
            }
        }
        return 0;
    }
}
