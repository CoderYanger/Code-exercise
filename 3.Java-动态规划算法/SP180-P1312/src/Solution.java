/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-26
 * Time: 15:55
 */
class Solution {
    //1312. 让字符串成为回文串的最少插入次数
    //看完算法原理，自己照着原理敲出来的
    //吴小哲我俩写的一摸一样
    public int minInsertions(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)) dp[i][j]=dp[i+1][j-1];
                else dp[i][j]=Math.min(dp[i][j-1],dp[i+1][j])+1;
            }
        }
        return dp[0][n-1];
    }
}