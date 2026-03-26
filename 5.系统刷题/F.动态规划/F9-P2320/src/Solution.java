/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-07
 * Time: 21:09
 */
class Solution {
    //2320. 统计放置房子的方式数
    //动态规划：未优化版
    private static final int MOD=1_000_000_007;
    public int countHousePlacements(int n) {
        return (int)(1L*rob(n)*rob(n)%MOD);
    }
    private int rob(int n){
        //dp0[i]：第i-1块地不选
        int[] dp0=new int[n];
        dp0[0]=1;
        //dp1[i]：第i-1块地选
        int[] dp1=new int[n];
        dp1[0]=1;
        for(int i=1;i<n;i++){
            //不选:前一块地可选可不选
            dp0[i]=(dp0[i-1]+dp1[i-1])%MOD;
            //选:前一块地必须不选
            dp1[i]=dp0[i-1];
        }
        return (dp0[n-1]+dp1[n-1])%MOD;
    }

    //优化版本动态规划
    private static final int MOD=1_000_000_007;
    private static final int MX=10_001;
    private static int[] dp=new int[MX];
    //静态代码块：程序只执行一次
    static{
        dp[0]=1;dp[1]=2;
        for(int i=2;i<MX;i++)
            dp[i]=(dp[i-1]+dp[i-2])%MOD;
    }
    public int countHousePlacements(int n) {
        return (int)(1L*dp[n]*dp[n]%MOD);
    }

}
