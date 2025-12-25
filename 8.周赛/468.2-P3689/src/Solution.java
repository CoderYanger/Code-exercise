import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-09
 * Time: 14:43
 */
class Solution {
    //3689.最大子数组总值 I
    public long maxTotalValue(int[] nums, int k) {
        Arrays.sort(nums);
        long max=nums[nums.length-1];
        long min=nums[0];
        return (long)(k*(long)(max-min));
    }
}