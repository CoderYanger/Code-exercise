/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-23
 * Time: 12:04
 */
class Solution {
    //100901. 最少反转次数得到翻转二进制字符串
    public int minimumFlips(int n) {
        //就是统计回文串，对称位置反转一次就行
        //将整数转为二进制字符串
        String s=Integer.toBinaryString(n);
        String reverse=new StringBuilder(s).reverse().toString();
        int ret=0;
        //遍历前半部分，比较对称位置的字符
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)!=reverse.charAt(i))
                ret++;
        return ret;
    }
}
