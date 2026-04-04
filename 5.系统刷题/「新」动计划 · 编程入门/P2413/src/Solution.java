/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-12
 * Time: 20:13
 */
class Solution {
    //2413. 最小偶倍数
    //0ms击败100.00%
    public int smallestEvenMultiple(int n) {
        return n%2==0?n:2*n;
    }
}
