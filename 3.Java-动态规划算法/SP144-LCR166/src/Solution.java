/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-15
 * Time: 13:17
 */
class Solution {
    //LCR 166. 珠宝的最高价值
    //看完算法原理后自己写的，一遍过
    public int jewelleryValue(int[][] frame) {
        int m=frame.length,n=frame[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+frame[i-1][j-1];
            }
        }
        return dp[m][n];
    }
}