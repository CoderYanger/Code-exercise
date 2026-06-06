/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-20
 * Time: 10:23
 */
class Solution {
    //2527. 查询数组异或美丽值
    //这题是我纯猜的，感觉就是脑筋急转弯，试了一下还真通过了~
    public int xorBeauty(int[] nums) {
        int ret=0;
        for(int x:nums) ret^=x;
        return ret;
    }
}