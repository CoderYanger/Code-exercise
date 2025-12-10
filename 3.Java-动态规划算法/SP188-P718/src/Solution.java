/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-27
 * Time: 20:05
 */
class Solution {
    //718. 最长重复子数组
    //看着算法原理自己写的，跟吴小哲写的一样
    public int findLength(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        int[][] dp=new int[m+1][n+1];
        int ret=0;
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    ret=Math.max(ret,dp[i][j]);
                }
        //自己写的时候放外边了
        // int ret=0;
        // for(int[] nums:dp)
        //     for(int x:nums)
        //         ret=Math.max(ret,x);
        return ret;
    }
}