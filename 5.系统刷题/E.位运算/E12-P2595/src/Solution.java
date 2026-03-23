/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-04
 * Time: 23:21
 */
class Solution {
    //2595. 奇偶位数
    //解法一：库方法+位掩码
    public int[] evenOddBit(int n) {
        int even=Integer.bitCount(n&0x55555555);
        return new int[]{even,Integer.bitCount(n)-even};
    }

    //解法二：遍历二进制数
    public int[] evenOddBit(int n) {
        int[] ret=new int[2];
        for(int i=0;n>0;n>>=1){
            ret[i]+=n&1;
            //切换奇偶
            i^=1;
        }
        return ret;
    }
}
