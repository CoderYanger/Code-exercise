/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-26
 * Time: 17:12
 */
class Solution {
    //1143. 最长公共子序列(模板题)
    //看完算法原理自己写的，" "没注意要加空格，另外i和j要从1开始，别的就没啥问题了
    //跟吴小哲写的一样
    public int longestCommonSubsequence(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        s1=" "+s1;s2=" "+s2;
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i)==s2.charAt(j)) dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[m][n];
    }
}