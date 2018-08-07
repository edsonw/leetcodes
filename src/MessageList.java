import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by woo23 on 2018/8/6.
 * 给定类似qq的消息队列， 每个代表对话id
 * 例如 1 2 1 4 5
 * 返回目前的对话排序 5 4 1 2
 */
public class MessageList {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int size = sc.nextInt();
            int[] nums = new int[size];
            for (int j = 0; j < size; j++) {
                nums[j] = sc.nextInt();
            }
            list.add(nums);
        }
        for (int i = 0; i < n; i++) {
            int[] nums = list.get(i);
            HashSet<Integer> set = new HashSet<>();
            System.out.print(nums[nums.length - 1]);
            set.add(nums[nums.length - 1]);
            for (int j = nums.length - 1; j > 0; j--) {
                if (!set.contains(nums[j - 1])) {
                    System.out.print(" ");
                    System.out.print(nums[j - 1]);
                    set.add(nums[j - 1]);
                }
            }
            System.out.println();
        }
    }
}
