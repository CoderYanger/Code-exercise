/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-11
 * Time: 13:34
 */
class Solution {
    //1186. 删除一次得到子数组最大和
    public int maximumSum(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        //dp[i][0]:以i位置为结尾且已删除字符的子数组最大和
        //dp[i][1]:以i位置为结尾且未删除字符的子数组最大和
        int[][] dp=new int[n][2];
        dp[0][0]=0;
        dp[0][1]=nums[0];
        int ret=nums[0];
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0]+nums[i],dp[i-1][1]);
            dp[i][1]=Math.max(dp[i-1][1],0)+nums[i];
            ret=Math.max(ret,Math.max(dp[i][0],dp[i][1]));
        }
        return ret;
    }

    //空间优化版
    public int maximumSum(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int dp0=0,dp1=nums[0];
        int ret=nums[0];
        for(int i=1;i<n;i++){
            dp0=Math.max(dp0+nums[i],dp1);
            dp1=Math.max(dp1,0)+nums[i];
            ret=Math.max(ret,Math.max(dp0,dp1));
        }
        return ret;
    }

}
