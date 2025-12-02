/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-10
 * Time: 18:08
 */
class Solution {
    //509. 斐波那契数
    //递归写法
    public int fib(int n) {
        return dfs(n);
    }
    public int dfs(int n){
        if(n==0||n==1) return n;
        return dfs(n-1)+dfs(n-2);
    }
    //记忆化搜索代码
    long[] memo;
    public int fib(int n) {
        memo=new long[n+1];
        //初始化
        Arrays.fill(memo,-1);
        return (int)dfs(n);
    }
    public long dfs(int n){
        if(memo[n]!=-1) return memo[n];
        if(n==0||n==1){
            memo[n]=n;//返回之前先放备忘录里
            return n;
        }
        memo[n]=dfs(n-1)+dfs(n-2);
        return memo[n];
    }
    public int fib(int n) {
        //动态规划
        int[] dp=new int[31];
        //为啥长度设置成n+1时不能通过呢?
        //原因：n=0时，下面 有dp[1]=1越界了
        dp[0]=0;dp[1]=1;
        for(int i=2;i<=n;i++) dp[i]=dp[i-1]+dp[i-2];
        return dp[n];
    }
}