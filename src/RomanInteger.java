/**
 * Created by edson on 2018/2/16.
 */
public class RomanInteger {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        int pre = 0;
        for (char c :chars) {
            switch (c) {
                case 'I':
                   result+=1;
                   pre = 1;
                   break;
                case 'V':
                    if(pre>=5||pre ==0)
                        result+=5;

                    else
                        result+=3;
                    pre = 5;

                    break;
                case 'X':
                    if (pre>=10||pre ==0)
                        result+=10;
                    else
                        result+=8;
                    pre = 10;
                    break;

                case 'L':
                    if(pre>=50||pre ==0)
                        result+=50;
                    else
                        result+=30;
                    pre = 50;
                    break;
                case 'C':
                    if (pre>=100||pre ==0)
                        result+=100;
                    else
                        result+=80;
                    pre = 100;
                    break;
                case 'D':
                    if(pre>=500||pre ==0)
                        result+=500;
                    else
                        result+=300;
                    pre = 500;
                    break;
                case 'M':
                    if (pre >= 1000||pre ==0)
                        result+=1000;
                    else
                        result+=800;
                    pre = 1000;
                    break;
                default:
                    break;
            }





        }
        return result;
    }
}
