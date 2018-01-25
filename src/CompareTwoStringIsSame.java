import java.util.List;

/**
 * Created by woo23 on 2018/1/18.
 * 解法1： （两重循环）。遍历str1的每一个元素和str2的进行比较，因为是可以循环的，所以当遍历str1到尾部但是str2还没到尾部的时候需要对index进行调整。
 *
 * 解法2：使用kmp算法
 */
public class CompareTwoStringIsSame {
    // TODO: 2018/1/18 比较两个字符串是否是同可以经过变换后相同的例如 abcbaa 和aaabcb是相同的
    public boolean isSame(String str1, String str2) {
        char[] longStr = str1.toCharArray();
        char[] shortStr = str2.toCharArray();

        int[] nextArray = createNextArray(str2);
        int j = 0;
        for (int i = 0; i < str1.length() && j < str2.length();){
            if (longStr[i] == shortStr[j]){
               i++;
               j++;
            } else {
                if (nextArray[j] == -1){
                    i++;
                } else{
                    i = i + j - nextArray[j];
                }

            }
        }

        if (j == str2.length()) {
            return true;
        } else {
            return false;
        }
    }
    public int[] createNextArray(String str1) {
        int[] subArray = new int[str1.length()];
        char[] p = str1.toCharArray();
        subArray[0] = -1;
        int j = 0;
        int len = -1;
        while (j < p.length -  1) {
            if (len == -1 || p[len] == p[j]) {
                len++;
                j++;
                subArray[j] = len;

            } else {
                len = subArray[len];
            }
        }
        return subArray;

    }

    public int[] prefixArray(String str1) {
        int[] prefixArray = new int[str1.length()];
        char[] p = str1.toCharArray();
        int j = 1;
        int len = 0;
        while (j < str1.length()){
            if (p[len] == p[j]){
                len++;
                prefixArray[j] = len;
                j++;
            } else {
                if (len > 0){
//      如果len大于0说明还可继续看前面一个元素是否和p[j]相同
                    len = prefixArray[len - 1];
                } else {
//                    如果len==0了说明前面没有元素和p[j]相同了直接
                    prefixArray[j] = len;
                    j++;
                }

            }
        }
        return prefixArray;
    }


}
