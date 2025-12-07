/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-20
 * Time: 20:28
 */
class Solution {
    //53.最大子数组和
    public int maxSubArray(int[] nums) {
        //看完算法原理后自己写的，不知道虚拟节点的不能遍历，导致出错了
        //吴小哲的就是一边遍历一边取值了，省着二次遍历了，其余都一样的
        int n=nums.length;
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++)
            dp[i]=Math.max(dp[i-1]+nums[i-1],nums[i-1]);
        int max=Integer.MIN_VALUE;
        //这里要从1开始，dp[0]是咱们自己设置的虚拟节点，0会干扰结果（比如第一个是负数）
        for(int i=1;i<=n;i++)
            max=Math.max(max,dp[i]);
        return max;
    }
}