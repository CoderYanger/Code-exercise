/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-12
 * Time: 20:19
 */
class Solution {
    //258. 各位相加
    //O(1)解法
    //1ms击败83.99%
    public int addDigits(int num) {
        return (num-1)%9+1;
    }
}
