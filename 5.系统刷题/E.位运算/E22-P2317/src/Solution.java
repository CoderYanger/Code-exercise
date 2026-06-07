/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-22
 * Time: 18:13
 */
class Solution {
    //2317. 操作后的最大异或和
    public int maximumXOR(int[] nums) {
        int ret=0;
        for(int x:nums) ret|=x;
        return ret;
    }
}