/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-29
 * Time: 11:00
 */
class Solution {
    //3512. 使数组和能被 K 整除的最少操作次数
    public int minOperations(int[] nums, int k) {
        int sum=0;
        for(int x:nums) sum+=x;
        return sum%k;
    }
}