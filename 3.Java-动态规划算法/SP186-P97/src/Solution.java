/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-27
 * Time: 18:04
 */
class Solution {
    //97. 交错字符串
    //看完算法原理后自己写了一遍，没处理边界条件导致出错了一次
    public boolean isInterleave(String s1, String s2, String s3) {
        int m=s1.length(),n=s2.length();
        if(m+n!=s3.length()) return false;//处理边界条件
        boolean[][] dp=new boolean[m+1][n+1];
        //初始化
        s1=" "+s1;
        s2=" "+s2;
        s3=" "+s3;
        dp[0][0]=true;
        //初始化第一列
        for(int i=1;i<=m;i++)
            if(s1.charAt(i)==s3.charAt(i))
                dp[i][0]=true;
            else break;
        //初始化第一行
        for(int j=1;j<=n;j++)
            if(s2.charAt(j)==s3.charAt(j))
                dp[0][j]=true;
            else break;
        //填表
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                //这是我写的
                // if(s1.charAt(i)==s3.charAt(i+j)&&dp[i-1][j]) dp[i][j]=true;
                // else if(s2.charAt(j)==s3.charAt(i+j)&&dp[i][j-1]) dp[i][j]=true;
                //这是吴小哲写的，更简洁些
                dp[i][j]=(s1.charAt(i)==s3.charAt(i+j)&&dp[i-1][j])||(s2.charAt(j)==s3.charAt(i+j)&&dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}
