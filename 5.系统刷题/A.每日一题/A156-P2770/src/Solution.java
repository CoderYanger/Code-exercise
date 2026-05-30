import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-11
 * Time: 13:09
 */
class Solution {
    //2770. 达到末尾下标所需的最大跳跃次数
    public int maximumJumps(int[] nums, int target) {
        int n=nums.length;
        //dp[i]：从下标0开始跳跃，到达 i 位置的最大跳跃次数
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        dp[0]=0;
        //枚举起跳位置
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
                if(-target<=nums[j]-nums[i]&&nums[j]-nums[i]<=target&&dp[i]!=-1)
                    //更新落点位置，取最大值
                    dp[j]=Math.max(dp[j],dp[i]+1);
        return dp[n-1];
    }
}
