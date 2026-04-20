/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-09
 * Time: 20:33
 */
public class Solution {
    //53.最大子数组和
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        //dp[i]:以i位置为结尾的所有子数组中的最大和
        int[] dp=new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++)
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
        int ret=-0x3f3f3f3f;
        for(int x:dp) ret=Math.max(ret,x);
        return ret;
    }

    //空间优化版
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int dp=nums[0];
        int ret=dp;
        for(int i=1;i<n;i++){
            dp=Math.max(dp+nums[i],nums[i]);
            ret=Math.max(ret,dp);
        }
        return ret;
    }


}
