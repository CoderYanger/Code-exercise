/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-02
 * Time: 13:11
 */
class Solution {
    //3226. 使两个整数相等的位更改次数
    //写法一：&
    public int minChanges(int n, int k) {
        return (n&k)==k?Integer.bitCount(n^k):-1;
    }

    //写法二：|
    public int minChanges(int n, int k) {
        return (n|k)==n?Integer.bitCount(n^k):-1;
    }

    //写法三：~
    public int minChanges(int n, int k) {
        return (k&~n)==0?Integer.bitCount(n^k):-1;
    }
}
