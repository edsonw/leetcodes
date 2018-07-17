/**
 * Created by edson on 2018/7/5.
 * 使用二分查找的方式来对被除数开方，从1次方，2次方，4次方等到开方的积大于了
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if(dividend<0&&divisor>0||dividend>0&&divisor<0)
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        if(ldivisor == 0) return Integer.MAX_VALUE;
        if(ldividend == 0 || ldividend<ldivisor) return 0;

        long times = ldivide(ldividend,ldivisor);
        int ans;
        if(times>Integer.MAX_VALUE){
            ans = (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
        } else{
            ans = (int)(sign*times);
        }
        return ans;



    }

    private long ldivide(long ldividend, long ldivisor){
        if(ldividend<ldivisor) return 0;
        long sum = ldivisor;
        int time = 1;
        while (sum+sum<ldividend){
            sum += sum;
            time +=time;
        }
        return time+ldivide(ldividend-sum,ldivisor);
    }
}
