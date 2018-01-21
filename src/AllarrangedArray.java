/**
 * Created by woo23 on 2017/12/15.
 * 数组的全排列，使用递归求解
 */
public class AllarrangedArray {
    public void solution(int[] nums) {
        fullArrage(nums, 0, nums.length);


    }

    private void fullArrage(int[] num,int start,int end ){
        if(start==end){
            for(int i =0;i<num.length;i++){
                System.out.print(num[i]);
            }
            System.out.println();
        }else{
            for(int i=start;i<end;i++){
                swap(num,i,start);
                fullArrage(num,start+1,end);
                swap(num,i,start);
            }
        }
    }

    private void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
