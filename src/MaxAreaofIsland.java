/**
 * Created by woo23 on 2017/12/13.
 * leetcode 695. Max Area of Island
 *
 * 思路：求解这一道问题的时候是没有什么思路的，根据题意是找出一个矩阵当中最大的不为0的连续区域，我考虑的是不是需要使用动态规划算法，后来发现是不用动态规划的，通过遍历矩阵当中的每个点，再判断这个点周围的面积
 *
 * 如何判断一个点周围的面积，首先判断这个点是否在矩阵的范围内，然后判断这个点如果是1的话那么就将这个点置为0，然后通过递归的方法判断这个点及其周围的点是否是1。最后返回这个点周围的面积。
 */
public class MaxAreaofIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int max=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<0;j++){
                if(grid[i][j] == 1)
                    max=Math.max(max,IlandArea(grid,i,j));
            }
        }
        return max;

    }
    private int IlandArea(int[][] grid,int i,int j){


        if(i>=0 && i<grid.length&&j>=0&&j<grid[0].length&&grid[i][j]==1){
            grid[i][j]=0;
            return 1+IlandArea(grid, i-1, j)+IlandArea(grid, i+1, j)+IlandArea(grid, i, j+1)+IlandArea(grid, i, j-1);
        }
        return 0;
    }
}
