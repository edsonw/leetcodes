/**
 * Created by woo23 on 2018/4/11.
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1,j = b.length() - 1;
        int flag = 0;
        while (i >= 0 || j >= 0){
            int sum = flag;
            if (i >= 0)sum += a.charAt(i--) - '0';
            if (j >= 0)sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            flag = sum / 2;
        }
        if (flag != 0)sb.append(flag);
        return sb.reverse().toString();
    }
}
