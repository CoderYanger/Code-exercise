/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-26
 * Time: 23:04
 */
class Solution {
    //44. 通配符匹配(迄今为止，状态转移方程最难推导的题)
    //看完吴小哲的算法原理，照着笔记自己敲出来的，跟吴小哲的差不多
    //他只是把不是*的放一起判断了：dp[i][j]=(p.charAt(j)=='?'||p.charAt(j)==s.charAt(i))&&dp[i-1][j-1];
    public boolean isMatch(String s, String p) {
        int m=s.length(),n=p.length();
        boolean[][] dp=new boolean[m+1][n+1];
        //初始化
        dp[0][0]=true;
        s=" "+s;p=" "+p;//处理下标映射关系,放在前面，否则下面到n会越界
        for(int i=1;i<=n;i++){
            char ch=p.charAt(i);
            if(ch!='*') break;
            else dp[0][i]=true;
        }
        for(int i=1;i<=m;i++){//s的行
            for(int j=1;j<=n;j++){//p的列
                if(p.charAt(j)=='?') dp[i][j]=dp[i-1][j-1];
                else if(p.charAt(j)=='*') dp[i][j]=dp[i][j-1]||dp[i-1][j];
                else
                if(s.charAt(i)==p.charAt(j)&&dp[i-1][j-1]==true) dp[i][j]=true;
            }
        }
        return dp[m][n];
    }
}