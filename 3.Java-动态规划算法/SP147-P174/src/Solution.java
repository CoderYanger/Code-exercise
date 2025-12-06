import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-16
 * Time: 22:45
 */
class Solution {
    //174. 地下城游戏
    //看完算法原理后自己写的，第二遍过的，第一遍错在了遍历方向反了
    public int calculateMinimumHP(int[][] nums) {
        int m=nums.length,n=nums[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        dp[m][n-1]=dp[m-1][n]=1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])-nums[i][j];
                dp[i][j]=Math.max(1,dp[i][j]);
            }
        }
        return dp[0][0];
    }
}