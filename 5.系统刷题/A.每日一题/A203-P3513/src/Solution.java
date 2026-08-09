/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-07-28
 * Time: 16:23
 */
class Solution {
    //3513. 不同 XOR 三元组的数目 I
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        return n<=2?n:1<<(32-Integer.numberOfLeadingZeros(n));
    }
}