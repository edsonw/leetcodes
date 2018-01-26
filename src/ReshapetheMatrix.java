import java.lang.reflect.Array;

/**
 * Created by woo23 on 2018/1/25.
 */
public class ReshapetheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        
        int row = nums.length;
        int column = nums[0].length;
        if(r*c != row*column)
            return nums;
        int[][] result = new int[r][c];

        int m = 0, k = 0;
        for(int i=0;i<row;i++) {
            for(int j=0; j<column; j++) {
                if( k >= c) {
                    m++;
                    k = 0;
                    result[m][k] = nums[i][j];
                    k++;
                } else {
                    result[m][k] = nums[i][j];
                    k++;
                }
            }
        }
        return result;
    }
}
