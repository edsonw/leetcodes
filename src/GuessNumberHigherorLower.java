/**
 * Created by woo23 on 2018/2/28.
 * 374 easy
 * 这里判断中位数的时候不要两个数相加除2这样会导致溢出，使用start+(end-start)/2 这样能让结果不溢出，并且使用中位数+1这样不会出现1+2一直等于1死循环。
 */
public class GuessNumberHigherorLower {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while(start<end) {
            int mid = start+(end-start)/2;
            if(guess(mid)==1)
                start = mid+1;

            else if(guess(mid)==-1)
                end = mid-1;
            else if(guess(mid)==0)
                return mid;
        }
        return start;
    }
}
