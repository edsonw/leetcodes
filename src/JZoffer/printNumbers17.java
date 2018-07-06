package JZoffer;

import java.util.Arrays;

/**
 * Created by woo23 on 2018/6/11.
 * 打印1到n位的所有数字，例如n为3就要打印1-999
 * 如果n特别大的话就会导致溢出
 * 通过单独判断每一次加数之后还能否继续加数比较困难，可以通过使用数组的全排列来完成打印，用一个递归算法来解决
 */
public class printNumbers17 {
    public void ToMaxOfNDigits(int n){
        int[] array = new int[n];
       /* while (true){
            if(array[n-1]!=9){
                System.out.println(array.toString());
            }else {
                int fla
            }
        }*/
       int index = 0;
       for(int i=0;i<10;++i){
           array[index]=i;
           helper(array,index);
       }
    }
    public void helper(int[] array,int index){
        if(index==array.length-1){
            printNumber(array);
            return;
        }

        for(int i=0;i<10;++i){
//            printNumber(array);
            array[index+1]=i;
            helper(array,index+1);
        }


    }
    public void printNumber(int[] array){
        String print= "";
        boolean flag= false;
        for(int ele:array){
            if(flag==false && ele!=0){
                flag = true;
                System.out.print(ele);
            }else if(flag==true){
                System.out.print(ele);
            }
        }
        System.out.print("\n");
    }

}
