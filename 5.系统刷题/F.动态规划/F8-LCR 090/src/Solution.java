/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-07
 * Time: 16:45
 */
class Solution {
    //LCR 090. 打家劫舍 II
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        else if(n==1) return nums[0];
        //选nums[0]
        int x=nums[0]+rob1(nums,2,n-1);
        //不选nums[0]
        int y=rob1(nums,1,n);
        return Math.max(x,y);
    }
    //直接搬198.打家劫舍
    //偷下标在[left,right)中的房子
    private int rob1(int[] nums,int left,int right) {
        if(left>right) return 0;//避免越界访问
        int n=nums.length;
        //dp0[i]：不选第i-1个房屋的最大价值
        int[] dp0=new int[n];
        dp0[left]=0;
        //dp1[i]：选第i-1个房屋的最大价值
        int[] dp1=new int[n];
        dp1[left]=nums[left];
        for(int i=left+1;i<right;i++){
            //选：前一个必须不选
            dp1[i]=dp0[i-1]+nums[i];
            //不选：前一个可选可不选
            dp0[i]=Math.max(dp1[i-1],dp0[i-1])+0;
        }
        return Math.max(dp0[right-1],dp1[right-1]);
    }

    //滚动数组空间优化
    public int rob(int[] nums) {
        int n=nums.length;
        //选nums[0]
        int x=nums[0]+rob1(nums,2,n-1);
        //不选nums[0]
        int y=rob1(nums,1,n);
        return Math.max(x,y);
    }
    //直接搬198.打家劫舍
    //偷下标在[left,right)中的房子
    private int rob1(int[] nums,int left,int right) {
        int dp0=0,dp1=0;
        for(int i=left;i<right;i++){
            int dp=Math.max(dp1,dp0+nums[i]);
            dp0=dp1;
            dp1=dp;
        }
        return dp1;
    }

}
