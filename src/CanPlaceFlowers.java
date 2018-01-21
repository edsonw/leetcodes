/**
 * Created by woo23 on 2018/1/5.
 * leetcode 605 给一个数组和一个数，判断数组当中能否放下这么多个数，每个数之间必须间隔
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {


        if(flowerbed.length==1&&n==1&&flowerbed[0]==0)
            return true;
        if(flowerbed.length==1&&n==1&&flowerbed[0]==1)
            return false;

        int pre = 0;
        for(int i=0;i<flowerbed.length; i++){
            if(pre==1&&flowerbed[i]==1){
                return false;
            }else{
                pre =flowerbed[i];
            }
        }


        for(int i=0;i<flowerbed.length&&n>0;i++){
            if(i==0){
                if (flowerbed[i+1]==0&&flowerbed[i]==0){
                    flowerbed[i]=1;
                    n--;
                    continue;
                }
            }else if(flowerbed[i-1]==0){
                if(flowerbed[i]==0){
                    if(i+1<flowerbed.length){
                        if(flowerbed[i+1]==0){
                            flowerbed[i]=1;
                            n--;
                        }
                    }else if(i+1==flowerbed.length){
                        flowerbed[i] = 1;
                        n--;
                    }

                }

            }

        }

        if (n == 0)
            return true;
        else
            return false;

//        最优解法 ，使用三元表达式，判断前一个和后一个元素是不是头一个和最后一个元素

        /*

        int count =0;
        for(int i = 0; i< flowerbed.length&& count<n; i++){
            if(flowerbed[i] == 0){
                int next = (i==flowerbed.length-1)?0:flowerbed[i+1];
                int pren = (i==0)?0:flowerbed[i-1];
                if(pren==0 && next == 0){
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }

         */



    }
}
