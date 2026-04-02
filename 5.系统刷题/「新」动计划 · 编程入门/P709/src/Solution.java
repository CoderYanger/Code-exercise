/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-12
 * Time: 20:18
 */
class Solution {
    //709. 转换成小写字母
    //0ms击败100.00%
    //解法一：Java内置方法
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
    //1ms击败39.53%
    //解法二：手动实现
    public String toLowerCase(String ss) {
        char[] s=ss.toCharArray();
        for(int i=0;i<s.length;i++)
            if(s[i]>='A'&&s[i]<='Z')
                s[i]=(char)(s[i]+32);
        return new String(s);
    }
}
