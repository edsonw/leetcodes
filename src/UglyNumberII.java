import java.util.Vector;

/**
 * Created by woo23 on 2018/2/28.
 * 题目当中给出的一个数的因素只包括2,3,5，也就是说能够被2，3,5整除，也就是说除了2,3,5之外的数都不是质数，质数是只有1和它本身整除，那么我们算出来所有的质数，然后挨个数不是质数的，就是要找的那个丑数。(这种方法是错误的，因为当这个数是其他质数的倍数的时候1是不对的）
 *
 * 正确思路：
 * 所有的丑数可以看作：
 * (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
 (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
 (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
 *将丑数看做的是将一个数组当中的数分别乘以2,3,5，所以可以看成是3个数组，但是由于这个数组是这三个数组合并的，所以当我们每次加入的都是三个数组当中最小的元素，然后那个数组的index++；
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
       /* int max = 1000000;
        boolean[]  A = new boolean[max];

        for(int i = 2;i<max;i++){
            if(A[i]==false){
                for (int j = 2;j * i < max; j++){
                    A[i * j]  = true;
                }
            }

        }
        int index =n-1;
        for(int i=1; i<max;i++){
            if(A[i])
                index--;
            if(index==0)
                return i;
        }
        return 0;
*/
       if (n <= 0)
           return 0;
       if (n == 1)
           return 1;
        int[] A = new int[n];
        A[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1;  i < n; i++){
             A[i] =Math.min(Math.min(2*A[i2],3*A[i3]),5*A[i5]);
            if (A[i] ==  A[i2]*2)
                i2++;
            if (A[i] ==  A[i2]*3)
                i3++;
            if (A[i] ==  A[i2]*5)
                i5++;
        }
        return A[n-1];

    }
}
