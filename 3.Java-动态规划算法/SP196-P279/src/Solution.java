/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-29
 * Time: 10:49
 */
class Solution {
    //279. 完全平方数
    //优化前的代码
    //看完算法原理后自己写的，一遍通过
    public int numSquares(int n) {
        int [][] dp=new int[(int)Math.sqrt(n)+1][n+1];
        //初始化
        for(int j=1;j<=n;j++) dp[0][j]=0x3f3f3f3f;
        for(int i=1;i<=(int)Math.sqrt(n);i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=i*i)
                    dp[i][j]=Math.min(dp[i][j],dp[i][j-i*i]+1);
            }
        }
        return dp[(int)Math.sqrt(n)][n];
    }

    //优化后的代码
    //依旧是自己写的，一遍通过
    public int numSquares2(int n) {
        int[] dp=new int[n+1];
        //初始化
        for(int j=1;j<=n;j++) dp[j]=0x3f3f3f3f;
        for(int i=1;i<=(int)Math.sqrt(n);i++)
            for(int j=i*i;j<=n;j++)
                dp[j]=Math.min(dp[j],dp[j-i*i]+1);
        return dp[n];
    }
}