/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-19
 * Time: 13:27
 */
class Solution {
    //2560. 打家劫舍 IV
    //解法一：二分查找+动态规划
    public int minCapability(int[] nums, int k) {
        int left=0,right=0;
        for(int x:nums) right=Math.max(right,x);
        while(left<right){
            int mid=left+(right-left)/2;
            if(!check(mid,nums,k)) left=mid+1;
            else right=mid;
        }
        return left;
    }
    //当窃取能力为mid时，能否窃取≥k个房屋
    private boolean check(int mid,int[] nums,int k){
        //dp0:遍历到当前房子时,不选当前房子的最大可选量
        //dp1:遍历到当前房子时的最大可选量,选不选都行
        int dp0=0,dp1=0;
        for(int x:nums){
            //x>mid不能选：dp0=之前的最多(dp1)
            if(x>mid) dp0=dp1;
                //x≤mid可以选:
                //选：dp1=前面必须不选+当前(dp0+1)
                //不选:dp0=之前的最多(dp1)
            else {
                int tmp=dp1;
                //新dp1=max(不选当前房屋最大值，选当前房屋最大值)
                dp1=Math.max(dp1,dp0+1);
                //新dp0=旧dp1
                dp0=tmp;
            }
        }
        return dp1>=k;
    }

    //解法二：二分查找+贪心
    public int minCapability(int[] nums, int k) {
        int left=0,right=0;
        for(int x:nums) right=Math.max(right,x);
        while(left<right){
            int mid=left+(right-left)/2;
            if(!check(mid,nums,k)) left=mid+1;
            else right=mid;
        }
        return left;
    }
    //窃取能力为mid时，最多能选多少个不相邻且≤mid的元素
    private boolean check(int mid,int[] nums,int k){
        int cnt=0;//记录能选的房屋数量
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=mid){
                cnt++;
                i++;//跳过下一间房屋
            }
        }
        return cnt>=k;
    }
}