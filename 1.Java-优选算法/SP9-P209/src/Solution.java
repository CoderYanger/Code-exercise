/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-22
 * Time: 18:17
 */
class Solution {
    // 209. 长度最小的子数组
    /*给定一个含有 n 个正整数的数组和一个正整数 target 。
    找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
    并返回其长度。如果不存在符合条件的子数组，返回 0 。
    示例 1：
    输入：target = 7, nums = [2,3,1,2,4,3]
    输出：2
    解释：子数组 [4,3] 是该条件下的长度最小的子数组。
    示例 2：
    输入：target = 4, nums = [1,4,4]
    输出：1
    示例 3：
    输入：target = 11, nums = [1,1,1,1,1,1,1,1]
    输出：0
    提示：
            1 <= target <= 109
            1 <= nums.length <= 105
            1 <= nums[i] <= 104
    进阶：
    如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。*/

    //自己写的，错误一堆，没找到
    //问题所在：只需要看right是否到尾就可以了，因为是滑动窗口，right不会从left再走一遍
    //没有用到最大整型来避免干扰
    /*public int minSubArrayLen(int target, int[] nums) {
        int left=0;int len=0;int sum=0;
        for(;left<nums.length;left++){
            int right=left;
            for(;right<nums.length;right++){
                if(sum>=target) {
                    len = Math.min(right - left, len);
                    sum -= nums[left];
                    break;
                }
                sum+=nums[right];
                len++;
            }
            if(right==nums.length&&sum<target){
                len=0;
            }
        }
        return len;
    }*/

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, len = Integer.MAX_VALUE;
        for (int left = 0, right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                len = Math.min(len, right - left + 1);
                sum -= nums[left++];
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        int target=11;
        Solution solution=new Solution();
        int len=solution.minSubArrayLen(target,nums);
        System.out.println(len);
    }
}
