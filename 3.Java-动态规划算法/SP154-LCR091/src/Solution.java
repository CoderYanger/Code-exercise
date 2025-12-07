/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-19
 * Time: 19:07
 */
class Solution {
    //LCR091.粉刷房子
    //吴小哲跟我写的一样
    //看完算法原理后自己写的，除了一开始忘记了下标映射关系导致的越界，其余一遍过
    public int minCost(int[][] costs) {
        int n=costs.length;
        int[][] dp=new int[n+1][3];
        //都是0，默认初始化已经帮我们搞定了
        for(int i=1;i<=n;i++){
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+costs[i-1][0];
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+costs[i-1][1];
            dp[i][2]=Math.min(dp[i-1][1],dp[i-1][0])+costs[i-1][2];
        }
        return Math.min(Math.min(dp[n][0],dp[n][1]),dp[n][2]);
    }
}