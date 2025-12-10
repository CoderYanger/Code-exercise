/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-26
 * Time: 18:15
 */
class Solution {
    //1035. 不相交的线
    //看完算法原理之后自己写的，跟最长公共子序列那个题一摸一样
    //吴小哲也这么写的
    public int maxUncrossedLines(int[] s1, int[] s2) {
        int m=s1.length,n=s2.length;
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                //注意下标的映射关系
                if(s1[i-1]==s2[j-1]) dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}