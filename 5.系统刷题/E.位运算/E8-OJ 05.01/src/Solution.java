/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-04
 * Time: 13:40
 */
class Solution {
    //面试题 05.01. 插入
    public int insertBits(int N, int M, int i, int j) {
        N&=~(((1<<(j-i+1))-1)<<i);
        return N|=(M<<i);
    }
}
