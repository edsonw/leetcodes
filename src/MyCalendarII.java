/**
 * Created by woo23 on 2018/2/1.
 *
 * 使用一个hashmap 存的key是start 和end ，value为是否是双重预定
 * 比较新的start、end和map中的start和end，如果有交叉，删除原有的，增加一个合并后的新的，标记为双重预定，然后用这个新的继续遍历看有没有交叉，如果有返回false，遍历完了如果没有删除需要删除的，加入map返回true。(这样少考虑了如果一段的一个部分是重复的，另一段没有重复，实际上这样的情况也是允许的。）
 */
import java.util.TreeSet;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
//我的解法
/*public class MyCalendarII {
    private HashMap<int[],Boolean> map;
    public MyCalendarII() {
        this.map = new HashMap<>();
    }

    public boolean book(int start, int end) {
        if (this.map.size() ==0) {
            int[] newArray = {start, end};
            this.map.put(newArray, true);
            return true;
        }
        int newStart, newEnd;
        int[] needDelete;
        boolean flag = false;
        for (int[] key: this.map.keySet()) {
            if (start >= key[1] || end <= key[0])
                continue;
            else {
                if (!map.get(key))
                    return false;

                needDelete = key;
                flag = true;
                if (key[0] < start)
                    start = key[0];
                if (key[1] > end)
                    end = key[1];

            }
        }

        int[] newArray = {start, end};
        if (flag){
            this.map.remove(needDelete);
            this.map.put(newArray, false);
        } else {
            this.map.put(newArray, true);
        }

        return true;
    }
}*/

class MyCalendarII {
    private List<int[]> books = new ArrayList<>();
    public boolean book(int s,int e) {
        MyCalendar overlaps = new MyCalendar();
        for (int[] b:books) {
            if(Math.max(b[0],s) < Math.min(b[1],e)) {
                if (!overlaps.book(Math.max(b[0], s),Math.min(b[1], e)))
                    return false;
            }
        }
        books.add(new int[]{s, e});
        return true;
    }

    private static class MyCalendar {
        List<int[]> books = new ArrayList<>();
        public boolean book(int start, int end) {
            for (int[] b:books) {
                if(Math.max(b[0], start) < Math.min(b[1], end))
                    return false;
            }
            books.add(new int[]{start, end});
            return true;

        }
    }
}
