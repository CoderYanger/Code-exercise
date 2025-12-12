/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-29
 * Time: 17:34
 */
class Solution {
    //879. 盈利计划
    //看着算法原理自己写的，一开始忘记取模导致报错了，其余基本一遍过
    //优化前的代码
    //跟吴小哲的大体一样，就是它把取模封装成MOD=(int)1e9+7了
    public int profitableSchemes(int n, int m, int[] g, int[] p) {
        int len=g.length;
        int[][][] dp=new int[len+1][n+1][m+1];
        //初始化
        for(int j=0;j<=n;j++) dp[0][j][0]=1;
        for(int i=1;i<=len;i++)
            for(int j=0;j<=n;j++)
                for(int k=0;k<=m;k++){
                    dp[i][j][k]=dp[i-1][j][k];
                    if(j>=g[i-1])
                        dp[i][j][k]+=dp[i-1][j-g[i-1]][Math.max(0,k-p[i-1])];
                    dp[i][j][k]%=1e9+7;
                }
        return dp[len][n][m];
    }

    //优化后的代码
    //自己顺势改的，改的时候for(int j=g[i-1];j>=0;j--)条件写错了，改错地方了
    //跟吴小哲的大体一样，就是它把取模封装成MOD=(int)1e9+7了
    public int profitableSchemes2(int n, int m, int[] g, int[] p) {
        int len=g.length;
        int[][] dp=new int[n+1][m+1];
        //初始化
        for(int j=0;j<=n;j++) dp[j][0]=1;
        for(int i=1;i<=len;i++)
            for(int j=n;j>=g[i-1];j--)//修改遍历顺序:for(int j=g[i-1];j>=0;j--)一开始改错成这个了
                for(int k=m;k>=0;k--){//修改遍历顺序
                    // dp[i][j][k]=dp[i-1][j][k];
                    // if(j>=g[i-1])
                    dp[j][k]+=dp[j-g[i-1]][Math.max(0,k-p[i-1])];
                    dp[j][k]%=1e9+7;
                }
        return dp[n][m];
    }
}