package JZoffer;

/**
 * Created by woo23 on 2018/6/12.
 */
public class SwitchOddEvenNumber {
    public void SwitchOddEvenNumber (int[] array){
        int i=0,j=array.length-1;
        while (i != j){
            if(array[i]%2==0){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j--;
            }else{
                i++;
            }
        }
    }
    public void switchOddEventInSameOrder(int[] array){
        if(array==null||array.length==0||array.length==1)
            return;
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0){
                int j=i+1;
                while (array[j]%2==0){
                    if(j<=array.length-2){
                        j++;
                    }else {
                        return;
                    }
                }
                int temp = array[j];
                while (i<j){
                    array[j]=array[j-1];
                    j--;
                }
                array[i]=temp;
            }
        }

    }
}
