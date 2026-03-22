/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-02
 * Time: 23:23
 */
class Solution {
    //476. 数字的补数
    //写法一
    public int findComplement(int num) {
        return num==0?1:~num&((1<<(32-Integer.numberOfLeadingZeros(num)))-1);
    }

    //写法二
    public int findComplement(int n) {
        return n==0?1:~n&((Integer.highestOneBit(n)<<1)-1);
    }
}
