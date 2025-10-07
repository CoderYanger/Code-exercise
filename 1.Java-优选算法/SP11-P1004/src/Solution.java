/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-23
 * Time: 01:34
 */
class Solution {
    //1004. 最大连续1的个数 III
    /*给定一个二进制数组 nums 和一个整数 k，假设最多可以翻转 k 个 0 ，
    则返回执行操作后 数组中连续 1 的最大个数 。
    示例 1：
    输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
    输出：6
    解释：[1,1,1,0,0,1,1,1,1,1,1]
    粗体数字从 0 翻转到 1，最长的子数组长度为 6。
    示例 2：
    输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
    输出：10
    解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
    粗体数字从 0 翻转到 1，最长的子数组长度为 10。
    提示：
            1 <= nums.length <= 105
    nums[i] 不是 0 就是 1
            0 <= k <= nums.length*/
    //自己照着思路写出来的
    public int longestOnes(int[] nums, int k) {
        int count=0,len=0;
        for(int left=0,right=0;right<nums.length;right++){
            if(nums[right]==0) count++;
            while(count>k){
                if(nums[left]==1) left++;
                else{left++;count--;}
            }
            len=Math.max(right-left+1,len);
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        Solution solution = new Solution();
        int i = solution.longestOnes(nums, k);
        System.out.println(i);
    }
}