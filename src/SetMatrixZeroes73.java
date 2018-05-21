import java.util.ArrayList;
import java.util.List;

/**
 * Created by woo23 on 2018/5/21.
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
