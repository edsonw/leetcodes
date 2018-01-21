/**
 * Created by woo23 on 2017/12/14.
 * leetcode 661 easy
 * Input:
 [[1,1,1],
 [1,0,1],
 [1,1,1]]
 Output:
 [[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
 Explanation:
 For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 */

public class ImageSmoother {
    /**
     * 将一个矩阵根据当中的元素除以周围元素的合
     * @param M 矩阵
     * @return 返回新的数组
     */
    public int[][] imageSmoother(final int[][] M) {

        int m = M.length;
        int n = M[0].length;

        int[][] re = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j= 0; j < n; j++){
                re[i][j] = helper(M, i, j);
            }
        }
        return re;
    }


  public int helper(final int[][] M, int m, int n){
        int value = 0;
        int count = 0;
        int row = M.length;
        int col = M[0].length;
    if (isValid(m-1,n-1, row,col)) {
        value=value+M[m-1][n-1];
        count++;
    }
        if (isValid(m,n-1,row,col)) {
            value=value+M[m][n-1];
            count++;
        }
        if (isValid(m+1,n-1,row,col)) {
            value=value+M[m+1][n-1];
            count++;
        }
        if (isValid(m+1,n,row,col)) {
            value=value+M[m+1][n];
            count++;
        }
        if (isValid(m- 1, n, row, col)) {
            value = value + M[m - 1][n];
            count++;
        }
        if (isValid(m - 1, n + 1, row, col)) {
            value = value + M[m - 1][n + 1];
            count++;
        }
        if (isValid(m,n + 1, row, col)) {
            value=value+M[m][n+1];
            count++;
        }
        if (isValid(m + 1, n + 1, row, col)) {
            value = value + M[m + 1][n + 1];
            count++;
        }
        value = value + M[m][n];
        count++;
        return value / count;

    }

  private boolean isValid(int x,int y,int row,int col) {
        return x >= 0 && x < row && y >= 0 && y < col; }
}
