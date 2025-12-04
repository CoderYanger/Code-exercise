/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-15
 * Time: 13:16
 */
class Solution {
    //63. 不同路径 II
    //看完算法原理后自己写的，除了nums忘记下标减1之外，其余一遍过
    public int uniquePathsWithObstacles(int[][] nums) {
        int m=nums.length,n=nums[0].length;
        int[][] dp=new int[m+1][n+1];
        dp[1][0]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                //这里记得nums是原数组，下标要减1
                if(nums[i-1][j-1]==1) dp[i][j]=0;
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}