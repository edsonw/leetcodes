/**
 * Created by woo23 on 2018/3/2.
 * 将一个圆分为N份 用M种颜色涂，相邻部分不能同色 求一共多少种涂法？
 * 错误解法：
 * 第一片可以选M种，第二片可以选M-1种，第N片可以选M-2种。（这种方法是不对的，因为N-1片可以和第一片相同或者不同。这样的考虑方式会导致出现的情况很多这里
 *
 * 正确解法：第一片可以有M种，后面的N-1片都每片都要M-1种。但是这种包含了最后一片和第一片相同的情况，所以要减去这部分。我们把最后一片和第一片相同时我们可以把这两片合并就可以看着是N-1片用M种来涂。
 *
 * 所以求A(N) = M*（M-1)^(N-1)-A(N-1) 然后一直依次递归下去
 * 当N=1的时候我们可以看作是线的两边不能是一样的 所以 N=1 是为0.
 *
 */
import java.util.Scanner;
public class AliQuestionOne {
    public static void main(){
        Scanner scan = new Scanner(System.in) ;
        int N = scan.nextInt();
        int M = scan.nextInt();

        /*int total = 1;
        for(int i=0;i<N;i++){
            if(i==N-1){
                total *= M-2;
            }else if (i==0){
                total *= M;
            }else{
                total *= M-1;
            }
        }
        System.out.print(total);*/

       System.out.print(helper(N, M));

    }
    private static int helper(int N,int M){
        if(N==0)
            return M;

        return M*(int)Math.pow(M-1,N-1)-helper(N-1, M);

    }

}
