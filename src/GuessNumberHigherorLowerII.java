import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by woo23 on 2018/3/1.
 * 给定一个数n，你每次猜一个数如果猜错了就要付你猜的数字的价格，如果猜对了就停止，求你总共要付多少。
 * 我的思路：使用二分查找，每一次都是查找靠后面的，这样找出来的都是最大的数。（但是理想情况并不是这样,这样的做法是并不是最优的，例如举个栗子，比如 n 为 5，系统选择的数字是 1。如果我先猜 3，系统提示你猜大了，然后再猜 2，系统提示你猜大了，那么你就可以确定是 1 了，花费 3+2=5。但是很明显第二次猜测应该猜 1，这样花费就少了。再比如我选的是 4，第一次还是猜 3，系统提示你猜小了，第二次猜 4，中了，总共花费 3+4=7，如果 n 为 5，至少需要 7？非也，正确的解法是先猜 4，如果数字在 1-3 之间，那么再猜 2，至少需要的应该是 6！）
 *
 * 正确的思路是我们记下（第一次我们从1-6当中猜，每次猜都会分为前后两个部分，而每次猜的费用就是m，前面部分的花费为x后面部分的花费为y，那么总的花费就是m+max（x+y）。然后再迭代的求x和y的花费，这里我们可以使用一个二维数组，存放每个start和end的花费，这样当我们要用到的时候如果记录在这个数组当中了可以直接取出。
 * 最后返回最优值，
 *
 * 参考：https://www.cnblogs.com/zichi/p/5701194.html
 *  https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84764/Simple-DP-solution-with-explanation~~
 */
public class GuessNumberHigherorLowerII {
    public int getMoneyAmount(int n) {
        /*int start = 1;
        int end = n;
        int total = 0;
        while (start < end){
            int medium = start + (end - start)/2;
            total += medium;
            start = medium+1;
        }
        return total;*/
        int[][] table = new int[n+1][n+1];
        return DP(table, 1, n);
    }


    private  int DP(int[][] t, int s ,int e) {
        if (s >= e) return 0;
        if (t[s][e] != 0) return t[s][e];
        int reslt = Integer.MAX_VALUE;
        for (int x = s; x <= e; x++) {
            int temp = x + Math.max(DP(t, s, x - 1), DP(t, x + 1, e));
            reslt = Math.min(reslt, temp);
        }
        t[s][e] = reslt;
        return reslt;
    }
}
