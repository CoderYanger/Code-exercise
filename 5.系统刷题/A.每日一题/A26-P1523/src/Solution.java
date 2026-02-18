/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-07
 * Time: 08:46
 */
class Solution {
    //1523. 在区间范围内统计奇数数目
    public int countOdds(int low, int high) {
        return (high+1)/2-low/2;
    }
}