/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-22
 * Time: 09:06
 */
class Solution {
    //868. 二进制间距
    //解法一：字符串+双指针
    public int binaryGap(int n) {
        int ret=0,prev=0;
        String s=Integer.toBinaryString(n);
        for(int i=1;i<s.length();i++)
            if(s.charAt(i)=='1'){
                ret=Math.max(ret,i-prev);
                prev=i;//更新‘1’的位置
            }
        return ret;
    }

    //解法二：位运算+双指针
    public int binaryGap(int n) {
        int ret=0,prev=-1;
        for(int i=0;n!=0;i++){
            if((n&1)==1){
                if(prev!=-1) ret=Math.max(ret,i-prev);
                prev=i;
            }
            n>>=1;
        }
        return ret;
    }

}