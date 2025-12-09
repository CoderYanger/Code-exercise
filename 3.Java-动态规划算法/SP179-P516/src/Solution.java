/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-26
 * Time: 15:00
 */
class Solution {
    //516. 最长回文子序列
    //看完算法原理后自己照着笔记敲出来的
    //跟吴小哲的差不多
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(i==j) dp[i][j]=1;
                    else if(i+1==j) dp[i][j]=2;
                    else dp[i][j]=dp[i+1][j-1]+2;
                }else dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
}
