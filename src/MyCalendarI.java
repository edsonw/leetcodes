/**
 * Created by woo23 on 2018/1/31.
 */
import java.util.ArrayList;
import java.util.List;
public class MyCalendarI {
    private List<int[]> list;
    public MyCalendarI() {
        this.list = new ArrayList<>();

    }

    public boolean book(int start, int end) {
        if (this.list.size() == 0) {
            int[] newArray = {start, end};
            this.list.add(newArray);
            return true;
        }

        for (int i=0;i<this.list.size(); i++) {
            int[] temp = this.list.get(i);
            if (start >= temp[1] || end <= temp[0])
                continue;
            else
                return false;
        }
        int[] newArray = {start, end};
        this.list.add(newArray);

        return true;
    }
}
