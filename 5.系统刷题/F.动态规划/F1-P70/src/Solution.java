/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-06
 * Time: 11:33
 */
class Solution {
    //70. 爬楼梯
    //基础思路：递归→寻找子问题（以下代码会超时）
    public int climbStairs(int n) {
        return dfs(n);
    }
    private int dfs(int i){
        if(i==1||i==0) return 1;
        return dfs(i-1)+dfs(i-2);
    }

    //第一次优化：记忆化搜索→递归+备忘录
    public int climbStairs(int n) {
        int[] memo=new int[n+1];
        return dfs(n,memo);
    }
    private int dfs(int i,int[] memo){
        if(i==1||i==0) return 1;
        if(memo[i]!=0) return memo[i];//之前计算过
        return memo[i]=dfs(i-1,memo)+dfs(i-2,memo);//存进memo并返回
    }

    //第二次优化：动态规划→去掉“递”，只留“归”
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;dp[1]=1;
        for(int i=2;i<=n;i++) dp[i]=dp[i-1]+dp[i-2];
        return dp[n];
    }

    //第三次优化：空间优化
    public int climbStairs(int n) {
        int dp0=1,dp1=1;
        for(int i=2;i<=n;i++){
            int dp=dp1+dp0;
            dp0=dp1;
            dp1=dp;
        }
        return dp1;
    }
}
