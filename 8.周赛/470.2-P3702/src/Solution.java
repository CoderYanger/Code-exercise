/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-09
 * Time: 14:51
 */
class Solution {
    //3702. 按位异或非零的最长子序列
    public int longestSubsequence(int[] nums) {
        int tmp=0;
        for(int x:nums) tmp^=x;
        if(tmp!=0) return nums.length;
        //找到让异或为0的位置
        for(int i=0;i<nums.length;i++)
            if(nums[i]!=0) return nums.length-1;
        return 0;
    }
}