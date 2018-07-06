import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;

/**
 * Created by woo23 on 2018/6/26.
 * 求两个数组的交集
 */
public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int num :nums1){
            if(map.containsKey(num)){
                int value = map.get(num);
                map.put(num, ++value);
            }else{
                map.put(num, 1);
            }
        }
        for(int num: nums2){
            if(map.containsKey(num)){
                    int value = map.get(num);
                    if(value>0){
                        list.add(num);
                        map.put(num,--value);
                    }


            }
        }
        int[] retArray = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            retArray[i] = list.get(i);
        }
        return retArray;
    }
}
