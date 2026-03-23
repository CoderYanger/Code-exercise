/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-06
 * Time: 13:02
 */
class Solution {
    //3693. 爬楼梯 II
    public int climbStairs(int n, int[] costs) {
        int[] dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            dp[i]=0x3f3f3f3f;
            //从前面爬几步到现在位置
            for(int j=1;j<=3;j++){
                if(i-j>=0){
                    int jumpCost=costs[i-1]+(j*j);
                    dp[i]=Math.min(dp[i],dp[i-j]+jumpCost);
                }
            }
        }
        return dp[n];
    }

    //滚动数组空间优化
    public int climbStairs(int n, int[] costs) {
        int dp0=0,dp1=0,dp2=0;
        for(int c:costs){
            int dp=Math.min(Math.min(dp2+1,dp1+4),dp0+9)+c;
            dp0=dp1;
            dp1=dp2;
            dp2=dp;
        }
        return dp2;
    }
}
