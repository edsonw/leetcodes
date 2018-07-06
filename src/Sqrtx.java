/**
 * Created by woo23 on 2018/6/27.
 * 输入一个数，返回这个数开根号
 */
public class Sqrtx {
    public int mySqrt(int x) {
        if(x==0)
            return 0;
        int start = 1;
        int end = Integer.MAX_VALUE;
        while (true){
            int medium = start+(end-start)/2;
            if (medium>x/medium){
                end = medium-1;
            }else{
                if(medium+1>x/(medium+1))
                    return medium;
                start =  medium+1;
            }
        }

    }
}
