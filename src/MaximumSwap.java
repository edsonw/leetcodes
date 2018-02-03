/**
 * Created by woo23 on 2018/1/25.
 * leetcode 670. Maximum Swap
 * 给一个数，交换其中两个位置的数使得这个数最大
 */


import java.util.ArrayList;
public class MaximumSwap {
    /*
    我的解决方案，两重循环，进行替换，记录第二重循环内最大的数，第二次循环内最大的数大于原来的数就说明替换是有效的。结束第一重循环，时间复杂度n^2

     */
        public int maximumSwap(int num) {

            int tmpnum = num;
            int max = -1;
            int maxRe = num;
            ArrayList<Integer> list = new ArrayList<>();

            while (num != 0) {
                int temp = num % 10;
                list.add(temp);
                num = (num - temp) / 10;
            }
            list.toArray();

            int len = list.size();
            for (int i= len - 1; i >= 0; i--) {

                for (int j = i-1; j >= 0; j--) {


                        ArrayList<Integer> tempList = new ArrayList<>(list);
                        int temp = tempList.get(i);
                        tempList.set(i, tempList.get(j));
                        tempList.set(j, temp);

                        int tempre = 0;
                        for (int m = len - 1; m >= 0; m--) {
                            tempre = tempre * 10 + tempList.get(m);
                        }

                        maxRe = Math.max(tempre, maxRe);

                }
                if (maxRe > tmpnum){
                    break;
                }
            }

            return maxRe;
    }

/*
高手的解决方案
 */
    public int maximumSwapNB(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] buckets = new int[10];
        for(int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }

        for (int i = 0; i <digits.length; i++) {
            for (int k =9; k > digits[i]-'0'; k--) {
                if(buckets[k] > i) {
                    char temp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = temp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
}

