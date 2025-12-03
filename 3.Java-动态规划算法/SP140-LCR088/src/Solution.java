/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-13
 * Time: 21:27
 */
class Solution {
    //LCR088.使用最小花费爬楼梯
    //吴小哲解法二代码(看完算法原理后自己写的)
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n];
        dp[n-1]=cost[n-1];dp[n-2]=cost[n-2];
        for(int i=n-3;i>=0;i--){
            dp[i]=Math.min(cost[i]+dp[i+1],cost[i]+dp[i+2]);
        }
        return Math.min(dp[0],dp[1]);
    }
}