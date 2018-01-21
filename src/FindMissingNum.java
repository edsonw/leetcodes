/**
 * Created by woo23 on 2017/12/9.
 * 给定一个数列，数列中的数字都出现偶数次，除了其中两个数字出现奇数次，找到这两个数字
 */
import java.util.Stack;
public class FindMissingNum {
    public void solution(int[] array){
        int count = 0;
        for(int i=0;i<array.length;i++){
            count = count^array[i];
        }

    }
}
