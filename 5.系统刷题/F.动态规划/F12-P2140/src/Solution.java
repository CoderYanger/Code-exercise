/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-08
 * Time: 22:48
 */
class Solution {
    //2140. 解决智力问题
    public long mostPoints(int[][] nums) {
        int n=nums.length;
        //选第i题能获得的最高分数
        long[] f=new long[n];
        f[n-1]=nums[n-1][0];
        //不选第i题能获得的最高分数
        long[] g=new long[n];
        g[n-1]=0;
        for(int i=n-2;i>=0;i--){
            //不选
            g[i]=Math.max(f[i+1],g[i+1]);
            //选
            //后nums[i][1]题不能选
            int j=i+nums[i][1];
            f[i]=(j+1<n?Math.max(f[j+1],g[j+1]):0)+nums[i][0];
        }
        return Math.max(f[0],g[0]);
    }

    //空间优化版
    public long mostPoints(int[][] nums) {
        int n=nums.length;
        //处理到第i题能获得的最高分数
        long[] dp=new long[n];
        dp[n-1]=nums[n-1][0];
        for(int i=n-2;i>=0;i--){
            //前一个的最大贡献
            int j=i+nums[i][1];
            long maxC=j+1<n?dp[j+1]:0;
            dp[i]=Math.max(dp[i+1],maxC+nums[i][0]);
        }
        return dp[0];
    }
}
