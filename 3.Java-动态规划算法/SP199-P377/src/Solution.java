/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-29
 * Time: 18:22
 */
class Solution {
    //377. 组合总和 IV
    //一开始自己写的时候线性dp就用一维的，导致用nums.length还是target搞蒙了
    //最后还是看的吴小哲的
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++)
            for(int x:nums)
                if(i>=x)
                    dp[i]+=dp[i-x];
        return dp[target];
    }
}