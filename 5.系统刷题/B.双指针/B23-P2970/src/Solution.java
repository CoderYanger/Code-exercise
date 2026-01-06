/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-18
 * Time: 22:36
 */
class Solution {
    //2970. 统计移除递增子数组的数目 I
    //解法一：暴力枚举
    public int incremovableSubarrayCount(int[] nums) {
        int n=nums.length;
        int ret=0;
        for(int i=0;i<n;i++)
            for(int j=i;j<n;j++)
                if(isincreasing(nums,i,j))
                    ret++;
        return ret;
    }
    public boolean isincreasing(int[] nums,int left,int right){
        for(int i=1;i<nums.length;i++){
            //跳过[left,right+1]这个区间，因为这个区间是要移除的，不需要检查原数
            //为啥右边界是right+1?因为是通过right+1来确定是否调整right的，这也是为什么要从1开始遍历的原因
            if(i>=left&&i<=right+1) continue;
            //检查区间外的元素，如果有前数>=后数，直接false，删也白删
            if(nums[i-1]>=nums[i]) return false;
        }
        //检查边界衔接：必须满足nums[left-1]<nums[right+1]
        //先确保left-1和right+1不越界，再判断大小关系
        if(left-1>=0&&right+1<nums.length&&nums[right+1]<=nums[left-1]) return false;
        return true;
    }

    public int incremovableSubarrayCount2(int[] nums) {
        int n=nums.length;
        int ret=0;
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