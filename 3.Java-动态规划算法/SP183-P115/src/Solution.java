/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-26
 * Time: 21:33
 */
class Solution {
    //115. 不同的子序列
    //看完算法原理后自己写了一遍，主要就是在行和列上与s和t的一一对应关系上出了点差错，导致一直不通过
    //跟吴小哲写的一样
    public int numDistinct(String s, String t) {
        int m=t.length(),n=s.length();
        int[][] dp=new int[m+1][n+1];
        //初始化
        for(int j=0;j<=n;j++) dp[0][j]=1;
        s=" "+s;t=" "+t;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]+=dp[i][j-1];
                if(t.charAt(i)==s.charAt(j))
                    dp[i][j]+=dp[i-1][j-1];
            }
        }
        return dp[m][n];
    }
}