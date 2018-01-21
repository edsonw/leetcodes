import sun.security.util.Length;

/**
 * 将数i
 * Created by woo23 on 2017/10/30.
 */

public class ReverseInteger {
    public int reverse(int x) {
        int reversedNum = 0;

        if (x>0){
            reversedNum = ReverseInteger.Helper(x);

        }else if(x<0){
            reversedNum = Helper(-x);
            reversedNum = 0-reversedNum;
        }

        return reversedNum;
    }

    public static int Helper(int num){
        int tempNum =0;
        Integer  numInteger = num;

        for (int i=0;i< numInteger.toString().length();i++){
        int last = num%10;
        num = (num-last)/10;
        tempNum = last*(10^(numInteger.toString().length()-i));

        }
        return tempNum;
    }

}
