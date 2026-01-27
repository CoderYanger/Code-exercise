/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-10
 * Time: 18:29
 */
class Solution {
    //2962. 统计最大元素出现至少 K 次的子数组
    public long countSubarrays(int[] nums, int k) {
        int n=nums.length;
        int left=0,count=0;
        long ret=0,max=0;
        //先找到最大值
        for(int x:nums) max=Math.max(max,x);
        for(int x:nums){
            //进窗口
            if(x==max) count++;
            //出窗口
            while(count>=k){
                if(nums[left]==max) count--;
                left++;
            }
            //更新
            ret+=left;
        }
        return ret;
    }
}