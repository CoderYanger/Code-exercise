/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-09
 * Time: 15:00
 */
class Solution {
    //3726. 移除十进制表示中的所有零
    public long removeZeros(long n) {
        long ret=0;
        String s=String.valueOf(n);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch!='0') ret=ret*10+(long)(ch-'0');
        }
        return ret;
    }
}