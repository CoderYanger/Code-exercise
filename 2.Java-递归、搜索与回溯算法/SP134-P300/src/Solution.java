import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-10
 * Time: 21:51
 */
class Solution {
    //300. 最长递增子序列
    //吴小哲的递归解法（记忆化搜索在新增的1.2处）
    int n;
    public int lengthOfLIS(int[] nums) {
        //递归版本+记忆化搜索版本
        n=nums.length;int ret=0;
        int[] memo=new int[n];
        for(int i=0;i<n;i++) ret=Math.max(ret,dfs(nums,i,memo));
        return ret;

        //动态规划版本
        n=nums.length;int ret=0;
        int[] dp=new int[n];
        Arrays.fill(dp,1);//自己本身就是一个长度
        //填表顺序：从后向前
        //dp表中的每一个数据都代表从此往后的最长长度
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(nums[j]>nums[i])//我这里不太熟练
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
            ret=Math.max(ret,dp[i]);
        }
        //int[] memo=new int[n];
        //for(int i=0;i<n;i++) ret=Math.max(ret,dfs(nums,i,memo));
        return ret;
    }
    public int dfs(int[] nums,int pos,int[] memo){
        //记忆化搜索新增1：如果备忘录里有就直接返回
        if(memo[pos]!=0) return memo[pos];
        int ret=1;
        for(int i=pos+1;i<n;i++)
            if(nums[i]>nums[pos])
                ret=Math.max(ret,dfs(nums,i,memo)+1);
        //记忆化搜索新增2：返回前存一下备忘录
        memo[pos]=ret;
        return ret;
    }
}