/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-19
 * Time: 15:46
 */
class Solution {
    //2429. 最小异或
    public int minimizeXor(int num1, int num2) {
        int c1=Integer.bitCount(num1);
        int c2=Integer.bitCount(num2);
        for(;c2<c1;c2++) num1&=num1-1;
        for(;c2>c1;c2--) num1|=num1+1;
        return num1;
    }
}