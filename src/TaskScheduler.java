/**
 * Created by edson on 2018/2/11.
 * leetcode 621 Task Scheduler medium
 * 给定义一个字符数组，不同的字符代表不同的任务，在两个相同的任务之间必须有n个间隔，间隔可以是另一个不同的任务，也可以是一个闲时状态。
 *
 * 解法：首先选出来出现次数最多的，然后在每个出现次数最多的任务里插入其他任务或者空闲状态。
 *
 */
import java.util.Arrays;
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] chars = new int[26];
        for(char a :tasks) {
            chars[a-'A']++;
        }
        Arrays.sort(chars);
        int i =25;
        while (i >=0 && chars[i] == chars[25]) i--;
        return Math.max(tasks.length,(chars[25]-1)*(n+1)+25-i);

    }
}
