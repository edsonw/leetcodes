package JZoffer;



/**
 * Created by woo23 on 2018/5/17.
 * 一个排序的数组，将这个数组的前面旋转到后面去，查找这个数组中的最小的元素
 *
 */
public class Findthenum11 {

    public int findMinNum(int[] arr){

        int medium = arr.length;

        return helper(arr,0, arr.length);

    }

    public int helper(int[] arr,int start,int end){

        if(end-start>1){
            if(arr[start]>=arr[end-1]){
                int mid = start+(end-start)/2;
                if(arr[start]>=arr[mid]){
                   return helper(arr,start,mid);
                }else if(arr[start]<arr[mid]){
                    return helper(arr,mid,end);
                }
            } else {
                return arr[start];
            }
        } else if(end-start==1){
            return arr[end];
        }
        return 0;
    }
}
