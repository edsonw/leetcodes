import java.io.PipedWriter;

/**
 * Created by woo23 on 2017/12/10.
 * leetcode 50
 * Implement pow(x, n).


 Example 1:

 Input: 2.00000, 10
 Output: 1024.00000
 Example 2:

 Input: 2.10000, 3
 Output: 9.26100
 难点：本题是要实现一个开方的函数，由于开发存在很多种情况，例如输入的n小于最小值时
 */

public class Pow {
    public double myPow(double x, int n) {
//
//        double MIN = -2147483648;
//        if(n<MIN){
//            return 0;
//        }
//        double sum =x;
//        if(n==0||x==0){
//            return 1;
//        }else{
//            if(n>0){
//
//                while (x!=0&&n!=0){
//                    x=x*sum;
//                    n--;
//                }
//                return x;
//            }else{
//                while (x!=0&&n!=0){
//                    x=x*sum;
//                    n--;
//                }
//                return 1/x;
//            }
//        }
        if(n==0)
            return 1;
        if(n<0){
            n=-n;
            x=1/x;
        }
        return (n%2)==0?myPow(x*x,n/2):x*myPow(x*x,n/2);


    }
}
