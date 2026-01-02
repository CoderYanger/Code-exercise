/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-14
 * Time: 12:30
 */
class Solution {
    //100932. 反转元音数相同的单词
    public String reverseWords(String ss) {
        //将字符串的单词转化成一个个单词
        String[] s=ss.split(" ");
        int n=s.length;
        int counts0=count(s[0]);
        StringBuffer tmp=new StringBuffer(s[0]);
        for(int i=1;i<n;i++){
            if(count(s[i])==counts0){
                StringBuffer sb=new StringBuffer(s[i]).reverse();
                tmp.append(" ").append(sb);
            }else{
                StringBuffer sb=new StringBuffer(s[i]);
                tmp.append(" ").append(sb);
            }
        }
        return tmp.toString();
    }
    private int count(String s){
        int ret=0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='a'||s.charAt(i)=='e'||
                    s.charAt(i)=='i'||s.charAt(i)=='o'||
                    s.charAt(i)=='u')
                ret++;
        return ret;
    }
}