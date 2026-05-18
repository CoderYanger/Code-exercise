/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 19:03
 */
class Solution {
    //3418. 机器人可以获得的最大金币数
    public int maximumAmount(int[][] coins) {
        int m=coins.length,n=coins[0].length;
        int[][][] dp=new int[m+1][n+1][3];
        for(int i=0;i<=m;i++) for(int j=0;j<=n;j++) Arrays.fill(dp[i][j],-0x3f3f3f3f);
        dp[0][1][0]=0;dp[1][0][0]=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                for(int k=0;k<=2;k++){
                    //选
                    int optionsA=Math.max(dp[i-1][j][k],dp[i][j-1][k])+coins[i-1][j-1];
                    //不选
                    int optionsB=-0x3f3f3f3f;
                    if(k>0&&coins[i-1][j-1]<0) optionsB=Math.max(dp[i-1][j][k-1],dp[i][j-1][k-1]);
                    dp[i][j][k]=Math.max(optionsA,optionsB);
                }
            }
        }
        return Math.max(dp[m][n][0],Math.max(dp[m][n][1],dp[m][n][2]));
    }
}