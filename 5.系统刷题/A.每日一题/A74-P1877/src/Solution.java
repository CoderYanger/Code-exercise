import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-24
 * Time: 21:04
 */
class Solution {
    //1877. 数组中最大数对和的最小值
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int ret=0;
        for(int i=0;i<n/2;i++)
            ret=Math.max(ret,nums[i]+nums[n-1-i]);
        return ret;
    }
}