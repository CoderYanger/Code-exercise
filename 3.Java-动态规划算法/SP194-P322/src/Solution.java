/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-29
 * Time: 10:21
 */
class Solution {
    //322. 零钱兑换
    //看着算法原理自己写的，一遍过
    //优化前的代码
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        int INF=0x3f3f3f3f;
        //初始化
        for(int j=1;j<=amount;j++) dp[0][j]=INF;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=coins[i-1])
                    //注意下标映射关系
                    dp[i][j]=Math.min(dp[i][j],dp[i][j-coins[i-1]]+1);
            }
        }
        dp[n][amount]=dp[n][amount]>=INF?-1:dp[n][amount];
        return dp[n][amount];
    }

    //优化后的代码
    //自己顺势改的，依旧一遍过
    public int coinChange2(int[] coins, int amount) {
        int n=coins.length;
        int[] dp=new int[amount+1];
        int INF=0x3f3f3f3f;
        //初始化
        for(int j=1;j<=amount;j++) dp[j]=INF;
        for(int i=1;i<=n;i++){
            for(int j=coins[i-1];j<=amount;j++){
                //注意下标映射关系
                dp[j]=Math.min(dp[j],dp[j-coins[i-1]]+1);
            }
        }
        dp[amount]=dp[amount]>=INF?-1:dp[amount];
        return dp[amount];
    }
}