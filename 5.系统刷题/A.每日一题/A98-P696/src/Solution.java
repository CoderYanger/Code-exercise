/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-19
 * Time: 11:39
 */
class Solution {
    //696. 计数二进制子串
    public int countBinarySubstrings(String ss) {
        char[] s=ss.toCharArray();
        int cur=1,prev=0,ret=0,n=s.length;
        for(int i=1;i<n;i++){
            if(s[i]!=s[i-1]){
                ret+=Math.min(prev,cur);
                prev=cur;
                cur=1;
            }else cur++;
        }
        //更新最后一段连续字符
        ret+=Math.min(prev,cur);
        return ret;
    }
}