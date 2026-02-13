/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-16
 * Time: 13:33
 */
class Solution {
    //1513. 仅含 1 的子串数
    public int numSub(String ss) {
        //动态规划解法
        int mod=1000000007;
        char[] s=ss.toCharArray();
        int n=s.length;
        int[] dp=new int[n];
        dp[0]=s[0]-'0';
        for(int i=1;i<n;i++)
            dp[i]=s[i]=='1'?(dp[i-1]+1)%mod:0;
        int ret=0;
        //累加时也要取模，避免溢出
        for(int x:dp) ret=(ret+x)%mod;
        return ret;
    }
}