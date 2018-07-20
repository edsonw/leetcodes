/**
 * Created by woo23 on 2018/2/28.
 * 233 easy 从1到n当中的数字中的1的个数
 * 我的思路：将所有的数字拼接为一个字符串，然后将字符串转为字符数组，判断这个字符数组当中‘1’的个数,这样做会超时。
 *
 * 正确解法：
 * 每10个数 有1个数的个位是1
 * 每100个数 有10个数的十位数是1
 * 每1000个数 有100个数的百位数是1
 */
public class NumberofDigitOne {
    public int countDigitOne(int n) {
     /*   String s = "";

        for(int i=1; i<=n; i++){
            s =s+i;
        }
        int count =0;
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='1')
                count++;
            i++;
        }
        System.out.println(s);
        return count;*/
        int count = 0;

        for (long k = 1; k <= n; k *= 10) {
            long r = n / k, m = n % k;
            // sum up the count of ones on every place k
            count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
        }

        return count;
    }
}
