/**
 * Created by woo23 on 2018/2/28.
 * 通过计算阶乘数字当中5的个数来判断0的个数。
 * 比如计算10的阶乘 当中5 和10 存在两个5那就说明有2个0
 * 如果是25那么25/5=5说明有6到25当中有5个5，然后继续计算0-5当中有几个5
 *
 * 如果使用传统的方法会导致存放不下阶乘结果过大的和。
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        //       传统思路
        /* double total=1;
        int count=0;
        for(int i=1;i<=n;i++){
            total = total*i;
            while (total%5==0){
                count++;
                total= total/5;
            }
        }
        return count;*/
        int count = 0;
        while (n>4){
            count = count+n/5;
            n= n/5;
        }
        return count;
    }
}
