/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-02
 * Time: 23:24
 */
class Solution {
    //1009. 十进制整数的反码
    //写法一
    public int bitwiseComplement(int num) {
        return num==0?1:~num&((1<<(32-Integer.numberOfLeadingZeros(num)))-1);
    }

    //写法二
    public int bitwiseComplement(int n) {
        return n==0?1:~n&((Integer.highestOneBit(n)<<1)-1);
    }
}
