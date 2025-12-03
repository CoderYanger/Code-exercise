/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-15
 * Time: 13:15
 */
class Solution {
    //62. 不同路径
    //看完算法原理之后自己写的，一遍过！
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        dp[0][1]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}