package JZoffer;

/**
 * Created by woo23 on 2018/6/11.
 * 实现一个开次方的函数
 */
public class powerFunction16 {
    public double power(int base, int exponent){
        double reslt = 1.0;
        if(exponent == 0)
            return 1;
        if(exponent<0){
            exponent = -exponent;
            for (int i=0; i<exponent; i++){
                reslt = reslt*base;
            }

            return 1 / reslt;
        }else{
            for (int i=0; i<exponent; i++){
                reslt = reslt*base;
            }
        }
        return reslt;
    }
}
