/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-18
 * Time: 17:42
 */
class Solution {
    //2997. 使数组异或和等于 K 的最少操作次数
    public int minOperations(int[] nums, int k) {
        for(int x:nums) k^=x;
        return Integer.bitCount(k);
    }
}
