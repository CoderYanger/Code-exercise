/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-29
 * Time: 14:00
 */
class Solution {
    //209. 长度最小的子数组
    //滑动窗口：在while循环内更新答案
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length,ret=0x3f3f3f3f,sum=0;
        for(int right=0,left=0;right<n;right++){
            //进窗口
            sum+=nums[right];
            while(sum>=target){
                //更新
                ret=Math.min(ret,right-left+1);
                //出窗口：尽可能缩小长度
                sum-=nums[left++];
            }
        }
        return ret==0x3f3f3f3f?0:ret;
    }

    //滑动窗口：在while循环内更新答案
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length,ret=0x3f3f3f3f,sum=0;
        for(int right=0,left=0;right<n;right++){
            //进窗口
            sum+=nums[right];
            //出窗口
            while(sum-nums[left]>=target) sum-=nums[left++];
            //更新
            if(sum>=target) ret=Math.min(ret,right-left+1);
        }
        return ret==0x3f3f3f3f?0:ret;
    }
}