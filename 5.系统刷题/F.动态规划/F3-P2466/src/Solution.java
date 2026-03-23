import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-06
 * Time: 20:10
 */
class Solution {
    //2466. 统计构造好字符串的方案数
    //写法一：直接套用组合总数Ⅳ
    private int MOD=1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] nums=new int[]{zero,one};
        long[] dp=new long[high+1];
        //初始化
        dp[0]=1;
        for(int i=1;i<high+1;i++){
            for(int x:nums){
                if(i>=x){
                    dp[i]+=dp[i-x]%MOD;
                }
            }
        }
        long sum=0;
        for(int i=low;i<high+1;i++) sum=(sum+dp[i])%MOD;
        return (int)sum;
    }

    //写法二：记忆化搜素
    private int MOD=1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int ret=0;
        int[] memo=new int[high+1];
        Arrays.fill(memo,-1);
        for(int i=low;i<=high;i++)
            ret=(ret+dfs(i,zero,one,memo))%MOD;
        return ret;
    }
    //获取构造长度为i的字符串需要的次数
    private int dfs(int i,int zero,int one,int[] memo){
        if(i<0) return 0;
        else if(i==0) return 1;
        if(memo[i]!=-1) return memo[i];
        return memo[i]=(dfs(i-zero,zero,one,memo)+dfs(i-one,zero,one,memo))%MOD;
    }

    //写法二：动态规划
    private int MOD=1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp=new int[high+1];
        dp[0]=1;
        int ret=0;
        for(int i=1;i<=high;i++){
            if(i>=zero) dp[i]=dp[i-zero];
            if(i>=one) dp[i]=(dp[i]+dp[i-one])%MOD;
            if(i>=low) ret=(ret+dp[i])%MOD;
        }
        return ret;
    }

}
