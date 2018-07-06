/**
 * Created by woo23 on 2018/3/4.
 * 合并两个有序的数组，其中数组1可以装下数组2，将有序数组存放到数组1当中
 *
 * 这道题我们从小到大是不好合并的，但是从大到小我们可以进行合并，并且我们在合并的时候如果nums1都合并到最后去了我们还要考虑到nums2数组剩下的元素没有合并完的情况。
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n-1;
        int i = m-1;
        int j = n-1;
        while(i>=0&&j>=0){
            nums1[k--] = nums1[i]>nums2[j]?nums1[i--]:nums2[j--];
        }
        while (j>-1)
            nums1[k--]=nums2[j--];

    }
}
