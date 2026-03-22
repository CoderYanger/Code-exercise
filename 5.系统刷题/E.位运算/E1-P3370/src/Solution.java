/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-02
 * Time: 13:04
 */
class Solution {
    //3370. 仅含置位位的最小整数
    //解法一：手写循环计算二进制个数（面试常写）
    public int smallestNumber(int n) {
        int cnt=0;
        while(n!=0){
            n>>>=1;
            cnt++;
        }
        return (1<<cnt)-1;
    }

    //解法二-写法一：用二进制最高位前0的个数间接求
    public int smallestNumber(int n) {
        int len=32-Integer.numberOfLeadingZeros(n);
        return (1<<len)-1;
    }

    //解法二-写法二：直接求二进制中最高的1所对应的十进制数值
    public int smallestNumber(int n) {
        return (Integer.highestOneBit(n)<<1)-1;
    }

}
