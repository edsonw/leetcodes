/**
 * Created by woo23 on 2018/2/28.
 * Super Ugly Number medium
 * 还是和丑数2相同的套路，要给每一个丑数的基设置一个index记下这个基的倍数，然后挨个比较每个基的倍数，找到最小的并加入到最终的数组当中，并且把倍数++；
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n<=0)
            return 0;
        if (n==1)
            return 1;
        int[] A = new int[n];
        int[] indexs = new int[primes.length];
        A[0] = 1;
        for (int i = 1; i<n; i++) {
            int temp =primes[0]*A[indexs[0]];
            for(int j= 1;j<primes.length; j++) {
                temp= Math.min(temp, primes[j]*A[indexs[j]]);
            }
            A[i] =temp;
            for (int j =0; j<primes.length;j++){
                if (A[i] == primes[j] * A[indexs[j]])
                    indexs[j]++;
            }
        }
        return A[n - 1];
    }
}
