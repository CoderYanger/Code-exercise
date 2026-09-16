/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:21
 */
class Solution {
    //3880. 两个值之间的最小绝对差值
    public int minAbsoluteDifference(int[] nums) {
        int ret=0x3f3f3f3f,prev=-1;
        for(int i=0;i<nums.length;i++){
            if(prev==-1&&nums[i]!=0) prev=i;
            if(prev!=-1){
                if(nums[prev]==1&&nums[i]==2||nums[prev]==2&&nums[i]==1){
                    ret=Math.min(ret,Math.abs(i-prev));
                    prev=i;
                }
                if(nums[prev]==nums[i]) prev=i;
            }
        }
        return ret==0x3f3f3f3f?-1:ret;
    }
}