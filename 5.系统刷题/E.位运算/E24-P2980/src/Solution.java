/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-26
 * Time: 15:41
 */
class Solution {
    //2980. 检查按位或是否存在尾随零
    public boolean hasTrailingZeros(int[] nums) {
        int cnt=0;
        for(int x:nums) if((x&1)==0) cnt++;
        return cnt>=2;
    }
}
