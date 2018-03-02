import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

/**
 * Created by woo23 on 2018/3/1.
 * 我的思路：将每一位取出来乘以该为所代表的位数，比如【1,2】就是先做2次再做10次，然后做循环，相乘，但是这样的做法会导致超时，当需要开方的次数过大的时候就会导致超时。
 *
 * 正确的做法：
 * a^b % 1337 = (a%1337)^b % 1337
 *  xy % 1337 = ((x%1337) * (y%1337)) % 1337
 *  其中第一个公式可以用来削减a的值, 第二个公式可以将数组一位位的计算, 比如 12345^678, 首先12345可以先除余1337, 设结果为X, 则原式就可以化为:

 X^78 = ((X^70 % 1337) * (X^8 % 1337)) % 1337 = (pow((X^7 % 1337), 10) * (X^8 % 1337)) % 1337
 */
public class SuperPow {
   /* static int b = 1337;
    public int pow (int a,int k) {
        a %= b;
        int result = 1;
        for (int i = 0;i < k; ++i) {
            result = (result * a) % b;
        }
        return result;

    }
    public int superPow(int a, int[] b) {
        if (b.length == 0)
            return 1;
        int total = 1;
        int i = b.length-1;
        while (i >= 0) {

            total = pow(a, b[i]*10) * total;
            i--;
        }
        return total;
    }*/


    public int superPow(int a,int[] b){
        return superPow(a,b,b.length,1337);
    }
    private int superPow (int a ,int[] b, int length, int k){
        if (length ==1)
            return powMod(a,b[0], k);
        return powMod(superPow(a,b,length-1,k),10,k)*powMod(a,b[length-1],k)%k;
    }
    private int powMod(int x,int y, int k) {
        x %= k;
        int pow =1;
        for(int i=0;i<y; i++){
            pow = (pow*x)%k;
        }
        return pow;
    }
}
