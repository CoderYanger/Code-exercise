/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-12
 * Time: 20:16
 */
class Solution {
    //1486. 数组异或操作
    //0ms击败100.00%
    public int xorOperation(int n, int start) {
        int ret=0;
        for(int i=0;i<n;i++) ret^=start+2*i;
        return ret;
    }
}
