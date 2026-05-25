/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-09
 * Time: 21:32
 */
class Solution {
    //3738. 替换至多一个元素后最长非递减子数组
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        if(n==1) return 1;
        int[] suf=new int[n];
        suf[n-1]=1;
        int ret=2;
        for(int i=n-2;i>0;i--){
            if(nums[i]<=nums[i+1]){
                suf[i]=suf[i+1]+1;
                //顺便处理替换i-1位置元素的情况
                ret=Math.max(ret,suf[i]+1);
            }else suf[i]=1;
        }
        int pre=1;
        for(int i=1;i<n-1;i++){
            //如果左边最后一个元素≤右边第一个元素，替换i后左右两段可以合并
            if(nums[i-1]<=nums[i+1]) ret=Math.max(ret,pre+1+suf[i+1]);
            //更新pre
            if(nums[i-1]<=nums[i]){
                pre++;
                //顺便处理替换i+1位置元素的情况
                ret=Math.max(ret,pre+1);
            }else pre=1;
        }
        return ret;
    }
}