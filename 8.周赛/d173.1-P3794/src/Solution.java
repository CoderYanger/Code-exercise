/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-05
 * Time: 22:24
 */
class Solution {
    //3794. 反转字符串前缀
    public String reversePrefix(String s, int k) {
        StringBuffer sb=new StringBuffer();
        for(int i=k-1;i>=0;i--) sb.append(s.charAt(i));
        sb.append(s.substring(k,s.length()));
        return sb.toString();
    }
}
