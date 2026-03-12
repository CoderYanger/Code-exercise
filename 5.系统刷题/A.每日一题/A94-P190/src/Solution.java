/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-16
 * Time: 13:30
 */
class Solution {
    //解法一：库函数
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    //解法二：分治+位运算
    //二进制：01010101 01010101 01010101 01010101
    //用于提取奇数位或分组交换相邻1位
    private static final int m0 = 0x55555555;
    //二进制：00110011 00110011 00110011 00110011
    //用于分组交换相邻2位
    private static final int m1 = 0x33333333;
    //二进制：00001111 00001111 00001111 00001111
    //用于分组交换相邻4位
    private static final int m2 = 0x0f0f0f0f;
    //二进制：00000000 11111111 00000000 11111111
    //用于分组交换相邻8位
    private static final int m3 = 0x00ff00ff;
    public int reverseBits(int n) {
        //交换相邻1位
        //n>>>1&m0 ：把原数右移1位，和m0相与 → 拿到原奇数位放到偶数位
        //(n&m0)<<1：把原数和m0相与后左移1位 → 拿到原偶数位放到奇数位
        //两者|运算 → 完成相邻两位互换
        n=n>>>1&m0|(n&m0)<<1;
        //交换相邻2位为一组
        n=n>>>2&m1|(n&m1)<<2;
        //交换相邻4位为一组
        n=n>>>4&m2|(n&m2)<<4;
        //交换相邻8位为一组
        n=n>>>8&m3|(n&m3)<<8;
        //交换高16位&低16位
        return n>>>16|n<<16;
    }
}
