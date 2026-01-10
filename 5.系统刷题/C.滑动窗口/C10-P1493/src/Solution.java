/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-24
 * Time: 18:49
 */
class Solution {
    //1493. 删掉一个元素以后全为 1 的最长子数组
    public int longestSubarray(int[] nums) {
        //维护滑动窗口：窗口内最多有一个0
        int n=nums.length;
        int zero=0,left=0,ret=0;
        for(int right=0;right<n;right++){
            if(nums[right]==0) zero++;
            //进窗口
            //出窗口
            while(zero>1){
                if(nums[left]==0) zero--;
                left++;
            }
            ret=Math.max(ret,right-left+1);
        }
        return ret-1;//注意把要删除的0减掉
    }
}
