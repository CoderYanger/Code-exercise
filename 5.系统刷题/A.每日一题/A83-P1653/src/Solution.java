/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-07
 * Time: 20:34
 */
class Solution {
    //1653. 使字符串平衡的最少删除次数
    //解法一：前后缀分解
    public int minimumDeletions(String ss) {
        char[] s=ss.toCharArray();
        //记录a的数量，代表删除所有a的删除次数
        int del=0;
        for(char c:s) del+='b'-c;
        int ret=del;
        //逐个确定分割线：
        //①遇a：将a移到分割线前，不删，del--
        //②遇b：将b移到分割线前，删，del++
        for(char c:s){
            if(c=='a') del--;
            else del++;
            ret=Math.min(ret,del);
        }
        return ret;
    }

    //解法二：动态规划
    public int minimumDeletions(String s) {
        int dp=0;
        int cnt=0;
        for(char c:s.toCharArray()){
            if(c=='b') cnt++;
            else dp=Math.min(dp+1,cnt);
        }
        return dp;
    }
}