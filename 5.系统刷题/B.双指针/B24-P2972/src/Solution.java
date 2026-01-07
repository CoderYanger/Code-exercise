/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-19
 * Time: 12:29
 */
class Solution {
    //2972. 统计移除递增子数组的数目 II
    public long incremovableSubarrayCount(int[] nums) {
        int n=nums.length;
        long ret=0;
        int l=1;
        //进行笔记的④部分
        //找最大的l，使[l,r]满足“移除递增子数组”
        while(l<n&&nums[l-1]<nums[l]) l++;
        //l<n的话把l也算上
        ret+=l+(l<n?1:0);
        //进行笔记的⑤部分
        //找右侧的r，使[r+1,n−1]单调递增
        for(int r=n-2;r>=0;r--){//n-1的部分上面已经累加完了
            //如果nums[l-1]和nums[r+1]不满足递增，就l--至nums[l-1]<nums[r+1]
            while(l>0&&nums[l-1]>=nums[r+1]) l--;
            //l<r的话把l也算上
            ret+=l+(l<=r?1:0);
            //nums[r]>=nums[r+1]说明r破坏了[r+1,n-1]的递增性了
            //r开始往右的区间已经不是递增了
            //此时左侧更小的r对应无效区间，必须用break跳出循环
            if(nums[r]>=nums[r+1]) break;
        }
        return ret;
    }
}
