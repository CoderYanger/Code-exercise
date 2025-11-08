/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-15
 * Time: 23:44
 */
class Solution {
    //844. 比较含退格的字符串
    public boolean backspaceCompare(String s, String t) {
        //自己按照1047的思路写的
        if(s.length()==0&&t.length()==0) return true;
        StringBuffer ss=new StringBuffer();
        StringBuffer tt=new StringBuffer();
        for(int i=0;i<s.length();i++){
            //已经是空了，仍遇到#，直接跳过这次循环
            if(ss.length()==0&&s.charAt(i)=='#') continue;
            if(ss.length()>0&&s.charAt(i)=='#') ss.deleteCharAt(ss.length()-1);
            else ss.append(s.charAt(i));
        }
        for(int i=0;i<t.length();i++){
            //已经是空了，仍遇到#，直接跳过这次循环
            if(tt.length()==0&&t.charAt(i)=='#') continue;
            if(tt.length()>0&&t.charAt(i)=='#') tt.deleteCharAt(tt.length()-1);
            else tt.append(t.charAt(i));
        }
        return ss.toString().equals(tt.toString());
        //用==是比较的地址,用equals才是比较内容
    }
}