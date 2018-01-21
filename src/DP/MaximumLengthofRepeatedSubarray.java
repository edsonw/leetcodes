package DP;

/**
 * Created by woo23 on 2017/12/11.
 * leetcode 718 最长连续公共子串
 * Input:
 A: [1,2,3,2,1]
 B: [3,2,1,4,7]
 Output: 3
 Explanation:
 The repeated subarray with maximum length is [3, 2, 1].

 */
public class MaximumLengthofRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
//       return helper(A,B)>helper(B,A)?helper(A,B):helper(B,A);

       int m = A.length;
       int n = B.length;
       int max = 0;
       int[][] dp = new int[m][n];
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(i==0||j==0){
                   dp[i][j] = 0;
               }else{
                   if(A[i]==B[j]){
                       dp[i][j] = dp[i-1][j-1]+1;
                   }else{
                       dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                   }
               }
           }
       }
        return dp[m][n];

    }


    
    public int findheper(int[] A,int[] B ,int m,int n){
        if(m==0||n==0)
            return 0;
        if(A[m-1]==B[n-1])
            return findheper(A,B,m-1,n-1)+1;
        else
            return findheper(A,B,m,n-1)>findheper(A,B,m-1,n)?findheper(A,B,m,n-1):findheper(A,B,m-1,n);
    }

    public int helper(int[] A, int[] B){
        int maxsame = 0;
        for(int i=0;i<A.length;i++){
            int max = 0;
            boolean flag=false;
            for(int j=0;j<B.length&&j+i<A.length;j++){
                if(false){
                    if(A[j+i]==B[j]){
                        max++;
                        if(max>maxsame)
                            maxsame = max;
                    }else{
                        max=0;
                        flag=false;
                        if(max>maxsame)
                            maxsame = max;
                    }
                }else if(!false){
                    if(A[j+i]==B[j]){
                        max=0;
                        max++;
                        flag=true;
                        if(max>maxsame)
                            maxsame = max;
                    }
                }
            }
        }
        return maxsame;
    }
}
