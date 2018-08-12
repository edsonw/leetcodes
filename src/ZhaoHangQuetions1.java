import sun.plugin.javascript.navig.LinkArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by woo23 on 2018/8/12.
 */
public class ZhaoHangQuetions1 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int peopleCount = sc.nextInt();
        int limit = sc.nextInt();
        HashMap<Character, ArrayList<Character>> map = new HashMap<>();
        sc.nextLine();
        String[] strArr = new String[peopleCount];
        for (int i = 0; i < peopleCount; i++) {
            strArr[i] = sc.nextLine();
        }

        for (int i = 0;i < peopleCount; i++) {
            String line = strArr[i];
           ArrayList<Character> list = new ArrayList<>();
            for (int j = 1;j <= limit; j++) {
                if (line.charAt(2 * j) != '*') {
                    list.add(line.charAt(2 * j));
                }
            }
            map.put(line.charAt(0), list);
        }

        for (int i = 0; i < peopleCount; i++) {
            ArrayList<Character>  list = map.get(strArr[i].charAt(0));
            for (int j = 0; j < list.size(); j++) {
                if (map.containsKey(list.get(j))) {
                   ArrayList<Character> tuijianzheList = map.get(list.get(j));
                   for (char c:tuijianzheList) {
                       if (!list.contains(c)) {
                           list.add(c);
                       }
                   }
                }
                map.replace(strArr[i].charAt(0), list);
            }
        }
        String res = "";
        for (char c : map.keySet()) {
            if (map.get(c).size() >= limit) {
                if (res.length() > 0) {
                    res += " " + c;
                } else {
                    res +=  c;
                }
            }
        }
        System.out.print(res);

    }
}
