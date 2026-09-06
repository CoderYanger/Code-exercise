/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:30
 */
class Solution {
    //3884. 双端字符匹配
    public int firstMatchingIndex(String s) {
        int n=s.length();
        for(int i=0;i<=n/2;i++)
            if(s.charAt(i)==s.charAt(n-1-i))
                return i;
        return -1;
    }
}