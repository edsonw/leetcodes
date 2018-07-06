import javax.swing.text.EditorKit;

public class TwoSumii167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] re = new int[2];
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]>target)
                break;;

            for(int j=i+1; j<numbers.length; j++){
                if(numbers[i]+numbers[j]==target){
                    re[0] = i+1;
                    re[1] = j+1;
                    break;
                }
            }
        }

        int start = 0,end = numbers.length-1;
        while (start<end){
            if(numbers[start]+numbers[end]==target){
                re[0]=start+1;
                re[1]= end+1;
                break;
            }
            if(numbers[start]+numbers[end]>target)
                end--;
            else if(numbers[start]+numbers[end]<target)
                start++;


        }
        return re;
    }
}
