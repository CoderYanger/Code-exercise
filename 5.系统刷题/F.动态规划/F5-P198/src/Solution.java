/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-07
 * Time: 15:14
 */
class Solution {
    //198. 打家劫舍
    public int rob(int[] nums) {
        int n=nums.length;
        //dp0[i]：不选第i-1个房屋的最大价值
        int[] dp0=new int[n];
        dp0[0]=0;
        //dp1[i]：选第i-1个房屋的最大价值
        int[] dp1=new int[n];
        dp1[0]=nums[0];
        for(int i=1;i<n;i++){
            //选：前一个必须不选
            dp1[i]=dp0[i-1]+nums[i];
            //不选：前一个可选可不选
            dp0[i]=Math.max(dp1[i-1],dp0[i-1])+0;
        }
        return Math.max(dp0[n-1],dp1[n-1]);
    }

    //滚动数组空间优化
    public int rob(int[] nums) {
        int n=nums.length;
        int dp0=0,dp1=0;
        for(int x:nums){
            int dp=Math.max(dp0+x,dp1);
            dp0=dp1;
            dp1=dp;
        }
        return dp1;
    }
}
