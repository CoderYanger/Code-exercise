/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-23
 * Time: 10:22
 */
class Solution {
    /*给你一个整数数组 nums 和一个整数 x 。每一次操作时，
    你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。
    请注意，需要 修改 数组以供接下来的操作使用。
    如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
    示例 1：
    输入：nums = [1,1,4,2,3], x = 5
    输出：2
    解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
    示例 2：
    输入：nums = [5,6,7,8,9], x = 4
    输出：-1
    示例 3：
    输入：nums = [3,2,20,1,1,3], x = 10
    输出：5
    解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
    提示：
            1 <= nums.length <= 105
            1 <= nums[i] <= 104
            1 <= x <= 109*/
    //自己一步一步改出来的，有点糙，还是去看课件好点
    public int minOperations(int[] nums, int x) {
        int sums=0;
        for(int a:nums) sums+=a;
        int target=sums-x,sum=0,len=0;
        if(target==0)return nums.length;
        if (target<0) return -1;
        for(int left=0,right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>target){
                sum-=nums[left++];
            }
            if(sum==target) {
                len = Math.max(len, right - left + 1);
            }
        }
        if(len==0) return -1;
        return nums.length-len;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309},134365));
    }
}