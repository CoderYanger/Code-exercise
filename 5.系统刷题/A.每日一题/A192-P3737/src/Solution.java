/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-26
 * Time: 15:57
 */
class Solution {
    //3737. 统计主要元素子数组数目 I
    public int countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        int ret=0;
        //遍历每一个左端点
        for(int i=0;i<n;i++){
            int cnt=0;
            //遍历每一个右端点
            for(int j=i;j<n;j++){
                //判断是否 target 在该子数组中出现的次数严格大于其长度的一半
                cnt+=(nums[j]==target?1:-1);
                if(cnt>0) ret++;
            }
        }
        return ret;
    }
}
