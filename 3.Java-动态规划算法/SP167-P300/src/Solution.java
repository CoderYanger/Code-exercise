import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-23
 * Time: 19:35
 */
class Solution {
    //300. 最长递增子序列
    //看完算法原理后自己写的，一遍过
    //跟吴小哲写的差不多，吴小哲用循环初始化，一边找一边统计，j从前往后找而已
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i])
                    //dp[i]只记录i前面最长的长度+1
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        int ret=Integer.MIN_VALUE;
        for(int x:dp) ret=Math.max(ret,x);
        return ret;
    }
}