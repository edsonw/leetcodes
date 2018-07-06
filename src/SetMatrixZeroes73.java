import java.util.ArrayList;
import java.util.List;

/**
 * Created by woo23 on 2018/5/21.
 * 另外的解法，先用一个标记为标记第0行和列是否有0，然后将第0行和第0列存储其他行和列是否有0
 */
public class SetMatrixZeroes73 {
    public void setZeroes(int[][] matrix){
        int row = matrix.length;
        int clumn = matrix[0].length;
        if (row == 0 || clumn == 0) {
            return;
        }
        List<Index> list = new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<clumn;j++){
                if(matrix[i][j]==0){
                    list.add(new Index(i,j));
                }
            }
        }

        for(Index index:list){
            changetozero(matrix,index.i,index.j,row,clumn);
        }
    }

    public void solution2(int[][] matrix){
        int row = matrix.length;
        int clumn = matrix[0].length;
        int row0 = 1;
        int clumn0 = 1;
        for(int i=0;i<row;i++){
            if(matrix[i][0] == 0){
                row0 = 0;
            }
        }
        for (int j =0;j<clumn;j++){
            if(matrix[0][j]==0)
                clumn0 = 0;
        }

        for(int i=0;i<row;i++){
            for(int j =0;j<clumn;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<clumn;j++){
                if(matrix[i][0]==0||matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }
        if(row0==0){
            for(int i=0;i<row;i++){
                matrix[i][0]=0;
            }
        }
        if(clumn0==0){
            for(int i=0;i<clumn;i++){
                matrix[0][i]=0;
            }
        }
    }

    public static void  changetozero(int[][] matrix,int i,int j, int row,int clumn){
            for(int ii=0;ii<row;ii++){
                matrix[ii][j]=0;
            }
            for(int jj=0;jj<clumn;jj++){
                matrix[i][jj]=0;
            }
    }

    private  class Index{
        private int i,j;
        public Index(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
