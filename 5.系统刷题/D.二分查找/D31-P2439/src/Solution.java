/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-17
 * Time: 08:11
 */
class Solution {
    //解法一：二分查找
    public int minimizeArrayValue(int[] nums) {
        int left=0,right=0;
        for(int x:nums) right=Math.max(right,x);
        while(left<right){
            int mid=left+(right-left)/2;
            if(!check(mid,nums)) left=mid+1;
            else right=mid;
        }
        return left;
    }
    //判断经过任意次操作后能否将最大值维持在≤mid
    private boolean check(int mid,int[] nums){
        long extra=0;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]+extra>mid) extra=(nums[i]+extra)-mid;
            else extra=0;
        }
        return extra==0;
    }

    //解法二：前缀和思想
    public int minimizeArrayValue(int[] nums) {
        long ret=0;
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            ret=Math.max(ret,(sum+i)/(i+1));
        }
        return (int)ret;
    }
}
