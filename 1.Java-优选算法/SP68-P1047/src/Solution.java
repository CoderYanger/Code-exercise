/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-15
 * Time: 23:26
 */
class Solution {
    //1047. 删除字符串中的所有相邻重复项
    public String removeDuplicates(String s) {
        //自己按照吴小哲的思路做出来的
        if(s.length()==0) return "";
        StringBuffer stack=new StringBuffer();
        stack.append(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(stack.length()>0&&stack.charAt(stack.length()-1)==s.charAt(i)) stack.deleteCharAt(stack.length()-1);
            else stack.append(s.charAt(i));
        }
        return stack.toString();
    }
}