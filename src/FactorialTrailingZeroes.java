/**
 * Created by woo23 on 2018/2/28.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        /*double total=1;
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
