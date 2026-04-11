/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-03
 * Time: 14:08
 */
class Solution {
    //3828. 删除子数组后的最终元素
    public int finalElement(int[] nums) {
        return Math.max(nums[0],nums[nums.length-1]);
    }
}
