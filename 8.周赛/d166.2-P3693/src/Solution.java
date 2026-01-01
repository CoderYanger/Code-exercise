/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-09
 * Time: 14:47
 */
class Solution {
    //3693. 爬楼梯 II
    public int climbStairs(int n, int[] costs) {
        int[] dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int j=1;j<=3;j++){
                if(i-j>=0){
                    int jumpCost=costs[i-1]+(j*j);
                    dp[i]=Math.min(dp[i],dp[i-j]+jumpCost);
                }
            }
        }
        return dp[n];
    }
}