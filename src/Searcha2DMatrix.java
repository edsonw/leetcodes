/**
 * Created by edson on 2018/7/6.
 */
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row =matrix.length;
        if(row==0)
            return false;
        int column = matrix[0].length-1;
        if(column<0)
            return false;
        boolean sign = false;
        for(int i =0;i<row;i++){
            if(matrix[i][0]<=target&&matrix[i][column]>=target)
                sign = sign||helper(matrix,target,i);
        }
        return sign;
    }

    public boolean helper(int[][] matrix ,int target,int row){

        int start = 0,end = matrix[row].length;
        int meduim = (end-start)/2+start;
        while (start<end){
            if(matrix[row][meduim]==target)
                return true;
            if(matrix[row][meduim]>target){
                end = meduim+1;
            }else if(matrix[row][meduim]<target){
                start = meduim-1;
            }
            meduim = (end-start)/2+start;
        }
        return false;
    }
}
