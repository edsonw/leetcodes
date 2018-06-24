/**
 * Created by woo23 on 2018/6/21.
 * 找出两个排序数组的中位数
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0,index2 = 0;
        int length1 = nums1.length,length2 = nums2.length;
        if(length1!=0&&length2!=0){


            while (index1<length1||index1<length2){
                if((length1 + length2) % 2 == 0) {
                    if((index1 + index2) < (length1 + length2)/2){
                        if(nums1[index1] < nums2[index2])
                            index1++;
                        else
                            index2++;
                    } else {
                        return (nums1[index1] + nums2[index2]) / 2;
                    }

                } else {
                    if ((index1+index2) < (length1+length2)/2){
                        if(nums1[index1]<nums2[index2])
                            index1++;
                        else
                            index2++;
                    } else {
                        return Math.min(nums1[index1], nums2[index2]);
                    }
                }

            }
        }else if(length1 == 0&&length2 != 0){
            if (length2%2 == 0) {
                return (nums2[length2/2]+nums2[length2/2-1])/2;
            } else {
                if(length2==1)
                    return nums2[0];
                return nums2[length2/2+1];
            }
        }else if (length2 == 0 && length1!=0){
            if(length1%2 == 0){
                return (nums1[length1/2]+nums1[length1/2-1])/2;
            }else {
                if(length1==1){
                    return nums1[0];
                }
                return nums1[length1/2+1];
            }
        }else {
            return 0;
        }
       return 0;
    }

//    一个笨但是有效的办法，存在另外一个数组当中，再从这个数组中找出中位点
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length+nums2.length+1];
        int size1 = nums1.length,size2 = nums2.length;
        int i = 0,j = 0,k = 0;
        while (i<size1&&j<size2){

            if(nums1[i]<nums2[j])
                merged[k++] = nums1[i++];
            else
                merged[k++] = nums2[j++];

        }
        if(i==size1){
            while (j<size2)
                merged[k++] = nums2[j++];
        }else {
            while (i<size1)
                merged[k++] = nums1[i++];

        }
        if(k%2 == 1)return merged[k / 2];
        else
            return (merged[k/2]+merged[k/2-1])/2.0;
    }
}
