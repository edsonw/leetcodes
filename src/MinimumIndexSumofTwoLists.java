/**
 * Created by woo23 on 2018/1/28.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
            int max = list2.length + list1.length;
            String sameString = "";
            ArrayList<String> list = new ArrayList<>();

            for (int i = 0; i < list1.length; i++) {
                for (int j = 0; j < list2.length; j++){
                    if (list1[i].equals(list2[j])&& i+ j < max){
                        list.clear();
                        max = i + j;
                        list.add(list1[i]);
                    }
                    else if (list1[i].equals(list2[j]) && i+ j == max){
                        list.add(list1[i]);
                    }
                }
            }

        String[] strs = list.toArray(new String[list.size()]);
            return  strs;


    }

/*
使用hashmap的方法
 */
public String[] findRestaurant2(String[] list1, String[] list2) {
    Map<String, Integer> map = new HashMap<>();
    List<String> res = new LinkedList<>();
    int minSum = Integer.MAX_VALUE;
    for (int i=0;i < list1.length;i++) map.put(list1[i], i);
    for (int i=0;i<list2.length;i++) {
        Integer j = map.get(list2[i]);
        if (j != null && i + j <= minSum) {
            if (i + j < minSum) { res.clear(); minSum = i+j; }
            res.add(list2[i]);
        }
    }
    return res.toArray(new String[res.size()]);
}
}
