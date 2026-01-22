/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-02
 * Time: 21:31
 */
class Solution {
    //2302. 统计得分小于 K 的子数组数目
    public long countSubarrays(int[] nums, long k) {
        int n=nums.length;
        long legal=0,ret=0,sum=0;
        for(int left=0,right=0;right<n;right++){
            //进窗口
            sum+=nums[right];
            legal=sum*(right-left+1);
            //出窗口
            while(legal>=k){
                sum-=nums[left++];
                legal=sum*(right-left+1);
            }
            //更新
            ret+=right-left+1;
        }
        return ret;
    }
}