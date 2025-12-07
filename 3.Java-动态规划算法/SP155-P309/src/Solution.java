/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-20
 * Time: 20:18
 */
class Solution {
    //309.最佳买卖股票时机含冷冻期
    //吴小哲跟我写的一样
    //看完算法原理后自己写的，没注意到这个不用创建虚拟节点，第一次执行的时候，下标的映射关系错了
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][3];
        dp[0][0]=-prices[0];
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][2]);
            dp[i][2]=dp[i-1][0]+prices[i];
        }
        return Math.max(dp[n-1][1],dp[n-1][2]);
    }
}