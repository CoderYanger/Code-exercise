/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-27
 * Time: 17:58
 */
class Solution {
    //10. 正则表达式匹配
    //自己写的时候状态转移方程直接用||了，后来看的吴小哲的
    //期间还有dp[0][j/2]置为true为什么也能通过和dp[i][j-2]为什么不会越界的问题已在下面注释处说明
    public boolean isMatch(String ss, String pp) {
        int m=ss.length(),n=pp.length();
        boolean[][] dp=new boolean[m+1][n+1];
        ss=" "+ss;pp=" "+pp;
        char[] s=ss.toCharArray();
        char[] p=pp.toCharArray();
        //初始化
        dp[0][0]=true;
        for(int j=2;j<=n;j+=2){
            //dp[0][j/2]不应该初始化为true，因为其不可能匹配空串，而p[2]=ture已经包括了这两个整体都能匹配空串了，所以是true，把dp[0][j/2]置为true也能通过是因为测试用例不全面，这种初始化逻辑上就是错误的
            if(p[j]=='*') dp[0][j]=true;
            else break;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(p[j]=='*')
                    //当j=1时dp[i][j-2]不会越界是因为，p的第一个不可能是*
                    dp[i][j]=dp[i][j-2]||(p[j-1]=='.'||p[j-1]==s[i])&&dp[i-1][j];
                else
                    dp[i][j]=(p[j]==s[i]||p[j]=='.')&&dp[i-1][j-1];
            }
        }
        return dp[m][n];
    }
}