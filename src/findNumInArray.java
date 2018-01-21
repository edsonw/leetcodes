/**
 * Created by woo23 on 2017/12/1.
 */
//在矩阵中找到指定的数
public class findNumInArray {
    public boolean Find(int target, int [][] array) {
        int row = array.length;
        int column = array[0].length;
        int i=0,j=column-1;
        while(j>=0&&i<row){
            if(array[i][j]==target){
                return true;

            }
            else if(array[i][j]>target){
                j--;
            }else{
                i++;
            }
        }

        return false;

    }
}
