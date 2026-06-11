/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-25
 * Time: 18:06
 */
class Solution {
    //1752. 检查数组是否经排序和轮转得到
    public boolean check(int[] nums) {
        int n=nums.length;
        boolean sorted=true;
        for(int i=1;i<n;i++){
            if(nums[i-1]>nums[i]){//严格递减
                //如果之前出现过严格递减，说明至少有三个递增段
                if(!sorted) return false;
                sorted=false;
            }
        }
        return sorted||nums[0]>=nums[n-1];
    }
}