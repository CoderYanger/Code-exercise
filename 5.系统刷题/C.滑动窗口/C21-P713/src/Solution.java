/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-02
 * Time: 19:37
 */
class Solution {
    //713. 乘积小于 K 的子数组
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int mul=1,ret=0;
        int n=nums.length;
        for(int left=0,right=0;right<n;right++){
            //进窗口
            mul*=nums[right];
            //出窗口
            while(mul>=k) mul/=nums[left++];
            //更新:对于固定的 right，有 right-left+1 个合法的左端点
            //而不是简单的ret++
            ret+=right-left+1;
        }
        return ret;
    }
}