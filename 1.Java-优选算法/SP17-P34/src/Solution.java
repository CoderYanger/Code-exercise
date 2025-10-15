/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-27
 * Time: 23:27
 */
class Solution {
    //34. 在排序数组中查找元素的第一个和最后一个位置
    /*给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
    如果数组中不存在目标值 target，返回 [-1, -1]。
    你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
    示例 1：
    输入：nums = [5,7,7,8,8,10], target = 8
    输出：[3,4]
    示例 2：
    输入：nums = [5,7,7,8,8,10], target = 6
    输出：[-1,-1]
    示例 3：
    输入：nums = [], target = 0
    输出：[-1,-1]
    提示：
            0 <= nums.length <= 105
            -109 <= nums[i] <= 109
    nums 是一个非递减数组
-109 <= target <= 109*/
    public int[] searchRange(int[] nums, int target) {
        int[] ret=new int[2];
        ret[0]=ret[1]=-1;
        if(nums.length==0) return ret;
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            //找左端点
            //求左端点mid要靠左：left+(right-left)/2;
            //当mid在实际左端点的左边时，left往mid上靠，而且要超过，否则死循环 left=mid+1;
            //right靠紧mid：right=mid;
            if(nums[mid]<target) left=mid+1;
            else right=mid;
        }
        if(nums[left]==target) ret[0]=left;
        right=nums.length-1;
        while(left<right){
            int mid=left+(right-left+1)/2;
            //找左端点
            //求左端点mid要靠左：left+(right-left)/2;
            //当mid在实际左端点的左边时，left往mid上靠，而且要超过，否则死循环 left=mid+1;
            //right靠紧mid：right=mid;
            if(target<nums[mid]) right=mid-1;
            else left=mid;
        }
        if(nums[left]==target) ret[1]=left;
        return ret;
    }
}
