/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-27
 * Time: 18:05
 */
class Solution {
    //712. 两个字符串的最小ASCII删除和
    //看完算法原理照着算法原理写出来的，一遍过
    //跟吴小哲写差不多一样，我的冗余些
    public int minimumDeleteSum(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        int[][] dp=new int[m+1][n+1];
        s1=" "+s1;s2=" "+s2;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                //这里是自己写的
                // if(s1.charAt(i)==s2.charAt(j))
                // dp[i][j]=Math.max(Math.max(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]+s1.charAt(i));
                // else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                //吴小哲写的
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                if(s1.charAt(i)==s2.charAt(j))
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+s1.charAt(i));
            }
        }
        int sum=0;
        for(int i=1;i<=m;i++) sum+=s1.charAt(i);
        for(int i=1;i<=n;i++) sum+=s2.charAt(i);
        return sum-2*dp[m][n];
    }
}