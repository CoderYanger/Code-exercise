/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-29
 * Time: 10:22
 */
class Solution {
    //518. 零钱兑换Ⅱ
    //优化前的代码
    //看完算法原理后自己写的，一遍过
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        //初始化
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=coins[i-1])
                    dp[i][j]+=dp[i][j-coins[i-1]];
            }
        }
        return dp[n][amount];
    }

    //优化后的代码
    //依旧是自己顺势改的，一遍过
    public int change2(int amount, int[] coins) {
        int n=coins.length;
        int[] dp=new int[amount+1];
        //初始化
        dp[0]=1;
        for(int i=1;i<=n;i++)
            for(int j=coins[i-1];j<=amount;j++)
                dp[j]+=dp[j-coins[i-1]];
        //吴小哲的for-each循环写法
        //for(int x:coins)
        //    for(int j=x;j<=amount;j++)
        //        dp[j]+=dp[j-x];
        return dp[amount];
    }
}