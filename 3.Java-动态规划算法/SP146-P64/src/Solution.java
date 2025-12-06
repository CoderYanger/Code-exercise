import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-15
 * Time: 17:04
 */
class Solution {
    //64. 最小路径和
    //看完算法原理后睡了三个小时，醒来一写一遍过！
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        dp[0][1]=dp[1][0]=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
            }
        }
        return dp[m][n];
    }
}