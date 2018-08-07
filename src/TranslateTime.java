import java.util.Scanner;

/**
 * Created by woo23 on 2018/8/6.
 * 输入一个时间字符串，如果字符串不符合规范则将其改为符合最小字典序的符合要求的字符串，如果符合要求就直接打印。
 */
public class TranslateTime {
    public void main(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strArr = new String[n];
        sc.nextLine();
        for (int i = 0; i < n; i++){
            strArr[i] = sc.nextLine();
        }

        for (int i = 0;i < n; i++){
            helper(strArr[i]);
        }


    }
    public void helper(String str){
        String[] strArr = str.split(":");
        int hour = Integer.parseInt(strArr[0]);
        int minite = Integer.parseInt(strArr[1]);
        int second = Integer.parseInt(strArr[2]);
        String strHour = "" + hour;
        String strMinite = "" + minite;
        String strSecond = "" + second;
        if (hour > 23){
           hour = hour % 10;
           strHour = "0" + hour;
        }
        if (minite > 59){
            minite = minite % 10;
            strMinite = "0" + minite;
        }
        if (second > 59){
            second = second % 10;
            strSecond = "0" + second;
        }

        if (hour < 10){
            strHour = "0" + hour;
        }
        if (minite < 10){
            strMinite = "0" + minite;
        }
        if (second < 10){
            strSecond = "0" + second;
        }
        String time = strHour + ":"+ strMinite + ":" + strSecond;
        System.out.println(time);

    }
}
