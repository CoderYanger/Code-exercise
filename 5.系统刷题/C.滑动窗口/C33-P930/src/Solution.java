/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-11
 * Time: 23:07
 */
class Solution {
    //930. 和相同的二元子数组
    //解法一：滑动窗口返回总和<=goal的子数组个数，用solve(nums,goal)-solve(nums,goal-1)
    public int numSubarraysWithSum(int[] nums, int goal) {
        return solve(nums,goal)-solve(nums,goal-1);
    }
    //统计总和<=goal的子数组个数
    private int solve(int[] nums,int goal){
        if(goal<0) return 0;
        long n=nums.length,sum=0;
        int ret=0;
        for(int left=0,right=0;right<n;right++){
            //进窗口
            sum+=nums[right];
            //出窗口
            while(left<=right&&sum>goal) sum-=nums[left++];
            //更新:以right为结尾的子数组数量是right-left+1
            ret+=right-left+1;
        }
        return ret;
    }
    //解法二：滑动窗口返回总和>=goal的子数组个数，用solve(nums,goal)-solve(nums,goal+1)
    public int numSubarraysWithSum(int[] nums, int goal) {
        return solve(nums,goal)-solve(nums,goal+1);
    }
    //统计总和>=goal的子数组个数
    private int solve(int[] nums,int goal){
        if(goal<0) return 0;
        long n=nums.length,sum=0;
        int ret=0;
        for(int left=0,right=0;right<n;right++){
            //进窗口
            sum+=nums[right];
            //出窗口
            while(left<=right&&sum>=goal) sum-=nums[left++];
            //更新:以right为结尾的子数组数量是right-left+1
            ret+=left;
        }
        return ret;
    }
}