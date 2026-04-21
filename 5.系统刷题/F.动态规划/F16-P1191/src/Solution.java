/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-10
 * Time: 17:06
 */
class Solution {
    //1191. K 次串联后最大子数组之和
    //未优化时的动态规划，时间超时，空间超限
    private static final int MOD=1_000_000_007;
    public int kConcatenationMaxSum(int[] nums, int k) {
        int n=nums.length;
        //dp[i]:以i位置结尾的最大数组和
        long[] dp=new long[n*k];
        dp[0]=nums[0];
        long ret=Math.max(0,nums[0]);
        for(int i=1;i<n*k;i++){
            //映射到原数组位置
            int index=i%n;
            dp[i]=Math.max(dp[i-1]+nums[index],nums[index]);
            ret=Math.max(ret,dp[i]);
        }
        return (int)(ret%MOD);
    }

    //优化版：动态规划+前缀和
    private static final int MOD=1_000_000_007;
    public int kConcatenationMaxSum(int[] nums, int k) {
        if(k==1) return maxSubArray(nums,1);
        long ret=maxSubArray(nums,2);
        long s=0;
        for(int x:nums) s+=x;
        return (int)((ret+Math.max(s,0)*(k-2)%MOD)%MOD);
    }
    //53. 最大子数组和-空间优化版
    public int maxSubArray(int[] nums,int k) {
        int n=nums.length;
        int dp=Math.max(nums[0],0);
        int ret=dp;
        for(int i=1;i<n*k;i++){
            int index=i%n;
            dp=Math.max(dp+nums[index],nums[index]);
            ret=Math.max(ret,dp);
        }
        return ret;
    }
}